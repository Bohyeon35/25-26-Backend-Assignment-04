package com.example.jwtexample.service;

import com.example.jwtexample.domain.Review;
import com.example.jwtexample.domain.Snack;
import com.example.jwtexample.domain.User;
import com.example.jwtexample.repository.ReviewRepository;
import com.example.jwtexample.repository.SnackRepository;
import com.example.jwtexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final UserRepository userRepository;
    private final SnackRepository snackRepository;
    private final ReviewRepository reviewRepository;

    public void addReview(Long userId, Long snackId, int score) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저를 찾을수없음"));

        Snack snack = snackRepository.findById(snackId)
                .orElseThrow(() -> new RuntimeException("과자를 찾을수없음"));

        Review review = Review.builder()
                .user(user)
                .snack(snack)
                .score(score)
                .build();

        reviewRepository.save(review);
    }
}

