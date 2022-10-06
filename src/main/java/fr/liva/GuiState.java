package fr.liva;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public enum GuiState {

    REGISTER(false),
    CONNECT(false),
    CHAT(false),
    WINDOW(false),
    MAIN(true),
    OPTIONS(true);

    private final boolean mainContent;
}
