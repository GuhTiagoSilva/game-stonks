package com.stonks.gamestonks.dto;

import com.stonks.gamestonks.enums.Status;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MessageDto {
    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;
}
