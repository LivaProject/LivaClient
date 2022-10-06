package fr.liva;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GuiState {

    SERVERS(true),
    REGISTER(false),
    CONNECT(false),
    CHAT(false),
    WINDOW(false),
    MAIN(true),
    OPTIONS(true);

    private final boolean mainContent;
}
