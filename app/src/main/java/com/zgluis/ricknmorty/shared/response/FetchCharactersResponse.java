package com.zgluis.ricknmorty.shared.response;

import com.zgluis.ricknmorty.model.Character;
import com.zgluis.ricknmorty.model.Info;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FetchCharactersResponse {
    private Info info;
    private List<Character> results;
}
