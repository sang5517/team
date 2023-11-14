package com.TeamProject.TeamProject.Review;


import com.TeamProject.TeamProject.MainController;
import com.TeamProject.TeamProject.Model.Restaurant;
import com.TeamProject.TeamProject.Model.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;


@RequestMapping("/review")
@RequiredArgsConstructor
@Controller
public class ReviewController {
    private final RestaurantService restaurantService;

    @PostMapping("/create/{id}")
    public String createReview(Model model, @PathVariable("id") Integer id, @RequestParam String content, @RequestParam String category,
                             @RequestParam String title, @RequestParam int rating) {
        // 특정 레스토랑 가져오기
        Restaurant restaurant = restaurantService.getRestaurantById(id);

        if (restaurant != null) {
            // 리뷰 생성
            Review review = new Review();
            review.setContent(content);
            review.setCategory(category);
            review.setTitle(title);
            review.setRating(rating);
            review.setRestaurant(restaurant);
            review.setCreateDate(LocalDateTime.now());


            Review savedReview = reviewService.createReview(review);

            // 리뷰가 저장되었다면 성공 메시지를 모델에 추가
            if (savedReview != null) {
              model.addAttribute("successMessage", "리뷰가 성공적으로 등록되었습니다.");
            } else {
              model.addAttribute("errorMessage", "리뷰 등록에 실패했습니다.");
            }
        } else {
          model.addAttribute("errorMessage", "레스토랑을 찾을 수 없습니다.");
        }

        // 리뷰가 등록된 레스토랑의 상세 페이지로 리다이렉트
        return "redirect:/restaurant/" + id;
    }
}
