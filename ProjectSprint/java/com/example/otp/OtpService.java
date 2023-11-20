package com.example.otp;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class OtpService {

    private final SecureRandom secureRandom = new SecureRandom();

    public String generateOtp() {
        // Generate a 6-digit random OTP
        int otp = 100_000 + secureRandom.nextInt(900_000);
        return String.valueOf(otp);
    }

	public static Object getCorrectOtp(String otpKey) {
		// TODO Auto-generated method stub
		return null;
	}
}
