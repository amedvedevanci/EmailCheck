# EmailCheck
A text-based Java app checking the validity of an email address according to the rules of the exercise

<h3>The Question:</h3>
<i>
Create an application that takes in 2 pieces of information from a user; a single email address and an array of 3 character domain extensions (eg com, edu, org). 
These should be taken in as parameters into a single method. This application only needs 2 methods; 1 that sets and computes and 1 that returns information.

The method should then do the following to validate the email address:

<ul>
  <li>Check that there is an @ symbol in the email address</li>
  <li>Check that there is a . before the 3 character extension</li>
  <li>Ensure that the domain extension is one of the 3 character Strings from the array</li>
</ul>

The method should return a String that states whether or not the email address is valid, and why.
</i>

<h3>Notes:</h3>
I additionally added a pattern matcher to verify the domain extensions - check that they consist of three characters and contain no special characters.
<br>If extending or rewriting, I would want to make or access a list of all domain extensions without the user having to enter them, then update the checker accordingly (to include 2-character domain extensions, for example).
