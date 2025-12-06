package com.github.satwiksanand.uber_review_service.service;

import com.github.satwiksanand.uber_review_service.models.Review;
import com.github.satwiksanand.uber_review_service.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hihahahhaha");
        Review r = Review.builder().review("amazing build quality").rating(5.0).build();
        reviewRepository.save(r);
    }
}
