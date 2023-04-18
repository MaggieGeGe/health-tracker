package com.example.backend.controller.request;

import lombok.Data;

import java.awt.font.ShapeGraphicAttribute;
@Data
public class UserPageRequest extends BaseRequest {
    private String name;
    private String phone;

}
