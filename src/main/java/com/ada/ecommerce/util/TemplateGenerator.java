package com.ada.ecommerce.util;

public class TemplateGenerator {
    public static String generateTemplateConfirmationToken(String name, String url) {
        return "<html> " +
                "<head>" +
                "<style>" +
                "body {font-family: 'Arial', sans-serif; background-color: #f4f4f4; padding: 20px;}" +
                ".container {max-width: 600px; margin: 0 auto;}" +
                ".card {background-color: #ffffff; padding: 30px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);}" +
                "h1 {color: #333333;}" +
                "p {color: #666666;}" +
                "a, button {display: inline-block; padding: 10px 20px; margin-top: 15px; text-align: center; text-decoration: none; border-radius: 5px;}" +
                "a {background-color: #4caf50; color: #ffffff;}" +
                "button {background-color: #4caf50; color: #ffffff; border: none;}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "<div class='card'>" +
                "<h1>¡Hello " + name + "!</h1>" +
                "<p>Please confirm your account by clicking the button below:</p>" +
                "<a href='" + url + "'>Confirm Account</a>" +
                "</div>" +
                "</div>" +
                "</body>" +
                "</html>";
    }

}
