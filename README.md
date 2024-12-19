# 2FA Implementation in Android Studio

This is an Android application that implements Two-Factor Authentication (2FA) using email-based OTP verification. It provides secure user account management and enhances security through a second layer of authentication.

## Features
- **User Registration**: Users can create accounts with an email and password.  
- **Email-Based OTP Verification**: After logging in, users receive a 6-digit OTP code via email for verification.  
- **Database Integration**: Stores user credentials securely.

##  Key Components
- **Platform**: Android with Java
- **Email Service**: JavaMail API for OTP delivery
- **Storage**: SQLite Database

## Installation
1. Clone this repository:  
   ```bash
   git clone https://github.com/aulonaramosaj/2FA_Implementation.git

## Usage

1. **Register a New User**:
   - Navigate to the registration screen.
   - Enter your username, email, and password to create an account.

2. **Log In**:
   - Enter your username and password.
   - A 6-digit OTP code will be sent to your email. Enter the OTP to complete the login process.

   
