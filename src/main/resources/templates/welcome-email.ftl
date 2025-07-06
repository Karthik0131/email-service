<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome to the Team!</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            color: #333;
        }
        .container {
            margin: 20px;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 10px;
        }
        h2 {
            color: #0066cc;
        }
        .footer {
            margin-top: 30px;
            font-size: 14px;
            color: #777;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Welcome, ${userName}!</h2>

    <p>We are thrilled to have you join the <strong>${department}</strong> department.</p>

    <p>Your official start date is <strong>${joiningDate}</strong>.</p>

    <p>If you need any help getting started, feel free to reach out to us at
        <a href="mailto:${supportEmail}">${supportEmail}</a>.
    </p>

    <p>We look forward to working with you and seeing the amazing things you'll accomplish!</p>

    <div class="footer">
        <p>Best regards,</p>
        <p>${name}</p>
    </div>
</div>
</body>
</html>
