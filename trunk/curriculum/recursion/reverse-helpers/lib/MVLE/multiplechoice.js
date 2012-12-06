var mc;
$(document).ready(function() {
    mc = new MC();
    mc.loadContent();
    mc.render();
    mc.postRender();


});

function MC() {
    this.content = {};
    this.properties = {};
    this.correctResponse = [];
	this.choices = [];
	this.attempts = [];
    this.states = [];

	//boolean to prevent shuffling after each answer submit
	this.previouslyRendered = false;
};

MC.prototype.loadContent = function() {

    // get the list of choices and related information

    // copy a reference to the instance variable array to use
    // within the callback function
    var choices = this.choices;
    $('.choice').each(function() {
        var elem = $(this);
        var choice = {
            identifier: elem.attr('identifier'),
            text: elem.find('.text').html(),
            feedback: elem.find('.feedback').html()
        };
        choices.push(choice);
    });

    // get user interaction information
    this.content.prompt = $('.prompt').html();
    this.properties.shuffle = $('#interaction').attr('shuffle');
    this.properties.maxChoices = $('#interaction').attr('maxchoices');

    // get the list of correct responses
    var corrResponses = $('.correctResponse')
    for(var i = 0; i != corrResponses.length; i++){
        this.correctResponse.push($(corrResponses[i]).attr('identifier'));
    }

    // set the page title and dispose the div
    // also used in postRender()
    document.title = $(".title").html();
    $(".title").remove();


};


//gets and returns a choice object given the choice's identifier
MC.prototype.getChoiceByIdentifier = function(identifier) {
	for (var i = 0; i < this.choices.length; i++) {
		if (this.removeSpace(this.choices[i].identifier) == identifier) {
			return this.choices[i];
		};
	};
	return null;
};

function displayNumberAttempts(part1, part2, states) {
	var nextAttemptNum = states.length + 1;
	var nextAttemptString = "";
	if (nextAttemptNum == 1) {
		nextAttemptString = "1st";
	} else if (nextAttemptNum == 2) {
		nextAttemptString = "2nd";
	} else if (nextAttemptNum == 3) {
		nextAttemptString = "3rd";
	} else {
		nextAttemptString = nextAttemptNum + "th";
	}
	$('#numberAttemptsDiv').html(part1 + " " + nextAttemptString + " " + part2 +".");
};

MC.prototype.tryAgain = function(e) {
    if ($("#tryAgainButton").hasClass("disabledLink")) {
        return;
    }
    mc.render();
};

/**
 * Render the MC
 */
MC.prototype.render = function() {
    if(!this.previouslyRendered) {
        // insert the basic page template
        // this should get changed to only remove the mc
        $('.MultipleChoice').html(pageTemplate);

        /* set the question type title */
        $('#questionType').html('Multiple Choice');
    }

	/* render the prompt */
	$('#promptDiv').html(this.content.prompt);

	/* remove buttons */
	var radiobuttondiv = document.getElementById('radiobuttondiv');
	while(radiobuttondiv.hasChildNodes()) {
		radiobuttondiv.removeChild(radiobuttondiv.firstChild);
	}

	/*
	 * if shuffle is enabled, shuffle the choices when they enter the step
	 * but not each time after they submit an answer
	 */
	if(this.properties.shuffle && !this.previouslyRendered){
		this.choices.shuffle();
	}

	/* set variable whether this multiplechoice should be rendered with radio buttons or checkboxes */
	if(this.properties.maxChoices==1){
		var type = 'radio';
	} else {
		var type = 'checkbox';
	}

	/* render the choices */
	for(var i = 0; i < this.choices.length; i++) {
		var choiceHTML = '<table><tbody><tr><td><input type="' + type + '" name="radiobutton" id="' + this.removeSpace(this.choices[i].identifier) +
			'" value="' + this.removeSpace(this.choices[i].identifier) + '" class="' + type + '"/></td><td><div id="choicetext:' + this.removeSpace(this.choices[i].identifier) +
			'">' + this.choices[i].text + '</div></td><td><div id="feedback_' + this.removeSpace(this.choices[i].identifier) + '" name="feedbacks"></div></td></tr></tbody></table>';

		$('#radiobuttondiv').append(choiceHTML);
		$('#' + this.removeSpace(this.choices[i].identifier)).click(function(){enableCheckAnswerButton('true');});

		if(this.selectedInSavedState(this.choices[i].identifier)){
			$('#' + this.removeSpace(this.choices[i].identifier)).attr('checked', true);
		}
	}

	$('#tryAgainButton').addClass('disabledLink');
    clearFeedbackDiv();

	if (this.correctResponse.length<1){
		// if there is no correct answer to this question (ie, when they're filling out a form),
		// change button to say "save answer" and "edit answer" instead of "check answer" and "try again"
		// and don't show the number of attempts.
		document.getElementById("checkAnswerButton").innerHTML = "Save Answer";
		document.getElementById("tryAgainButton").innerHTML = "Edit Answer";
	} else {
		displayNumberAttempts("This is your", "attempt", this.attempts);
	};

	if(this.states.length > 0){
        //the student previously answered the question correctly
        var latestState = this.states[this.states.length - 1];
		//display the message that they correctly answered the question
		var resultMessage = this.getResultMessage(latestState.isCorrect);
		$('#resultMessageDiv').html(resultMessage);
        if(latestState.isCorrect) {
            $('#tryAgainButton').addClass('disabledLink');
        }

	}
    //turn this flag on so that the step does not shuffle again during this visit
	this.previouslyRendered = true;

	//this.node.view.eventManager.fire('contentRenderComplete', this.node.id, this.node);
};

/**
 * Determine if challenge question is enabled
 */
MC.prototype.isChallengeEnabled = function() {
	return false;
};


/**
 * Determine if scoring is enabled
 */
MC.prototype.isChallengeScoringEnabled = function() {
	var result = false;

	if(this.properties.attempts != null) {
		var scores = this.properties.attempts.scores;

		//check if there are scores
		result = challengeScoringEnabled(scores);
	}

	return result;
};

/**
 * Given a choiceId, checks the latest state and if the choiceId
 * is part of the state, returns true, returns false otherwise.
 *
 * @param choiceId
 * @return boolean
 */
MC.prototype.selectedInSavedState = function(choiceId){
	if(this.states && this.states.length>0){
		var latestState = this.states[this.states.length -1];
		for(var b=0;b<latestState.length;b++){
			if(latestState.choices[b]==choiceId){
				return true;
			};
		};
	};

	return false;
};

/**
 * If prototype 'shuffle' for array is not found, create it
 */
if(!Array.shuffle){
	Array.prototype.shuffle = function (){
        for(var rnd, tmp, i=this.length; i; rnd=parseInt(Math.random()*i), tmp=this[--i], this[i]=this[rnd], this[rnd]=tmp);
    };
};

/**
 * Returns true if the choice with the given id is correct, false otherwise.
 */
MC.prototype.isCorrect = function(id){
	/* if no correct answers specified by author, then always return true */
	if(this.correctResponse.length==0){
		return true;
	};

	/* otherwise, return true if the given id is specified as a correct response */
	for(var h=0;h<this.correctResponse.length;h++){
		if(this.correctResponse[h]==id){
			return true;
		};
	};
	return false;
};

/**
 * Checks Answer and updates display with correctness and feedback
 * Disables "Check Answer" button and enables "Try Again" button
 */
MC.prototype.checkAnswer = function() {
	if ($('#checkAnswerButton').hasClass('disabledLink')) {
		return;
	}

	//clear the previous result message
	$('#resultMessageDiv').html('');

	this.attempts.push(null);

	var radiobuttondiv = document.getElementById('radiobuttondiv');
	var inputbuttons = radiobuttondiv.getElementsByTagName('input');
	var mcState = {};
	var isCorrect = true;

	if(!this.enforceMaxChoices(inputbuttons)){
		return;
	}

	enableRadioButtons(false);        // disable radiobuttons
	$('#checkAnswerButton').addClass('disabledLink'); // disable checkAnswerButton
	$('#tryAgainButton').removeClass('disabledLink'); // show try again button

	for (var i=0;i<inputbuttons.length;i++) {
		var checked = inputbuttons[i].checked;
		var choiceIdentifier = inputbuttons[i].getAttribute('id');  // identifier of the choice that was selected
		// use the identifier to get the correctness and feedback
		var choice = this.getChoiceByIdentifier(choiceIdentifier);

		if (checked) {
			if (choice) {
			    $('#feedback_' + choiceIdentifier).html(choice.feedback);

				var choiceTextDiv = document.getElementById("choicetext:" + choiceIdentifier);
				if (this.isCorrect(choice.identifier)) {
					choiceTextDiv.setAttribute("class", "correct");
				} else {
					choiceTextDiv.setAttribute("class", "incorrect");
					isCorrect = false;
				}

				mcState.identifier = choice.identifier;

				//add the human readable value of the choice chosen
				mcState.text = choice.text;
			} else {
				//this.node.view.notificationManager('error retrieving choice by choiceIdentifier', 3);
                alert('error retrieving choice by choiceIdentifier');
			}
		} else {
			if(this.isCorrect(choice.identifier)){
				isCorrect = false;
			}
		}
	}

	mcState.isCorrect = isCorrect;

    if(isCorrect){
		//the student answered correctly

		//get the congratulations message and display it
		$('#resultMessageDiv').html(this.getResultMessage(isCorrect));
        $('#checkAnswerButton').addClass('disabledLink'); // disable checkAnswerButton

	}

	//fire the event to push this state to the global view.states object
	//eventManager.fire('pushStudentWork', mcState);

	//push the state object into this mc object's own copy of states
	this.states.push(mcState);
    return false;
};

/**
 * Returns true iff this.maxChoices is less than two or
 * the number of checkboxes equals this.maxChoices. Returns
 * false otherwise.
 */
MC.prototype.enforceMaxChoices = function(inputs){
	var maxChoices = parseInt(this.properties.maxChoices);
	if(maxChoices>1){
		var countChecked = 0;
		for(var x=0;x<inputs.length;x++){
			if(inputs[x].checked){
				countChecked += 1;
			};
		};

		if(countChecked>maxChoices){
			//this.node.view.notificationManager.notify('You have selected too many. Please select only ' + maxChoices + ' choices.',3);
            var maxChoices = 3
            alert('You have selected too many. Please select only ' + maxChoices + ' choices.')
			return false;
		} else if(countChecked<maxChoices){
			//this.node.view.notificationManager.notify('You have not selected enough. Please select ' + maxChoices + ' choices.',3);
            var maxChoices = 3
            alert('You have not selected enough. Please select ' + maxChoices + ' choices.')
			return false;
		};
	};
	return true;
};

/**
 * Given whether this attempt is correct, adds any needed linkTo and
 * constraints and returns a message string.
 *
 * @param boolean - isCorrect
 * @param boolean - noFormat, return plain text
 * @return string - html response
 */
MC.prototype.getResultMessage = function(isCorrect){
	var message = '';

	/* if this attempt is correct, then we only need to return a msg */
	if(isCorrect){
		message = "You have successfully completed this question!";
    }

    return message;
};

/**
 * Returns a string of the given string with all spaces removed.
 */
MC.prototype.removeSpace = function(text){
	return text.replace(/ /g,'');
};


/**
 * enable checkAnswerButton
 * OR
 * disable checkAnswerButton
 */
function enableCheckAnswerButton(doEnable) {
	if (doEnable == 'true') {
		$('#checkAnswerButton').removeClass('disabledLink'); // disable checkAnswerButton
	} else {
		$('#tryAgainButton').addClass('disabledLink'); // disable checkAnswerButton
	}
};


/**
 * Enables radiobuttons so that user can click on them
 */
function enableRadioButtons(doEnable) {
	var radiobuttons = document.getElementsByName('radiobutton');
	for (var i=0; i < radiobuttons.length; i++) {
		if (doEnable == 'true') {
			radiobuttons[i].removeAttribute('disabled');
		} else {
			radiobuttons[i].setAttribute('disabled', 'true');
		};
	};
};

/**
 * Clears HTML inside feedbackdiv
 */
function clearFeedbackDiv() {
	var feedbackdiv = document.getElementById('feedbackdiv');
	feedbackdiv.innerHTML = "";

	var feedbacks = document.getElementsByName('feedbacks');
	for(var z=0;z<feedbacks.length;z++){
		feedbacks[z].innerHTML = "";
	};
};

MC.prototype.postRender = function() {

	var thetitle = document.title;
    $("#questionType").html(thetitle);

}

var pageTemplate =
'<div id="centeredDiv" class="bg7"> <div id="questionCountBox" class="bg8"> <div id="questionTable"> <div class="color1" id="questionType"> Multiple Choice </div> </div> </div> <!-- end of questionCountBox --> <div id="currentQuestionBox"> <div id="leftColumn" class="bg8"> <div id="promptDiv"> Prompt goes here. This text will automatically be replaced by actual prompt.  </div> <div id="radiobuttondiv"> </div> <div id="feedbackdiv"> </div> </div> <div id="rightColumn" class="bg2"> <img src="../MVLE/images/multi_choice.png" alt="Robot Art Open Response"  border="0" /> </div> </div> <div id="clearBoth"> </div> <div id="interactionBox"> <div id="statusMessages"> <div id="numberAttemptsDiv"> </div> <div id="scoreDiv"> </div> <div id="resultMessageDiv" style="font-size:16px"> </div> </div> <!-- Anchor-Based Button Layout using TABLE --> <div id="buttonDiv"> <table id="buttonTable"> <tr> <td> <div class="buttonDiv ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"> <a class="disabledLink" id="checkAnswerButton" href="#" onclick="mc.checkAnswer();">Check Answer</a> </div> </td> <td> <div class="buttonDiv ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"> <a id="tryAgainButton" class="disabledLink" href="#" onclick="mc.tryAgain();">Try Again</a> </div> </td> </tr> </table> </div> </div> </div> ';
