<?php
// Check for empty fields
if(empty($_POST['email-address'])      ||
   !filter_var($_POST['email-address'],FILTER_VALIDATE_EMAIL))
   {
   echo "No arguments Provided!";
   return false;
   }
   

$email_address = strip_tags(htmlspecialchars($_POST['email-address']));

   
// Create the email and send the message
$to = 'dukecatalyst@gmail.com'; // Add your email address inbetween the '' replacing yourname@yourdomain.com - This is where the form will send a message to.
$email_subject = "Add to listserv";
$email_body = "Someone wants to be added to the Catalyst listserv. Here is the email: $email_address";
$headers = "From: dukecatalyst@gmail.com\n"; // This is the email address the generated message will be from. We recommend using something like noreply@yourdomain.com.
$headers .= "Reply-To: $email_address";   
mail($to,$email_subject,$email_body,$headers);
return true;         
?>