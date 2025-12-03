package com.cybersport.tournament_backend.dto.request;

import com.cybersport.tournament_backend.model.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreateReviewRequest {
    @NotBlank
    private String author;

    @NotBlank
    private String text;

    private String avatarImage;

    @NotNull
    private UserRole role;

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public UserRole getRole() {
        return role;
    }


}
