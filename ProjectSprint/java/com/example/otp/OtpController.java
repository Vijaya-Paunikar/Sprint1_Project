package com.example.otp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/otp")
public class OtpController 
{
    private final Map<String, OtpDetails> otpMap = new HashMap<>();

    @GetMapping("/generate")
    public String generateOtp() 
    {
        // Generate a random 6-digit OTP
        int otp = generateRandomOtp();
        String otpKey = generateOtpKey();

        // Store the OTP with its details
        OtpDetails otpDetails = new OtpDetails(otp, System.currentTimeMillis());
        otpMap.put(otpKey, otpDetails);

        return "Generated OTP: " + otp + ". Use the key for verification: " + otpKey;
    }

    private int generateRandomOtp() {
        // Generate a 6-digit OTP
        return 100000 + new SecureRandom().nextInt(900000);
    }

    private String generateOtpKey() {
        // Generate a unique key for OTP verification
        return Long.toHexString(System.currentTimeMillis());
    }

    private static class OtpDetails {
        private final int otp;
        private final long timestamp;

        public OtpDetails(int otp, long timestamp) {
            this.otp = otp;
            this.timestamp = timestamp;
        }

		public int getOtp() {
			return otp;
		}

		public long getTimestamp() {
			return timestamp;
		}
        
    }
}