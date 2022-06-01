package mate.academy.javabot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class MateAcademyBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "exclusive_by_yevhenii_bot";
    }

    @Override
    public String getBotToken() {
        return "2010994343:AAG8bgidc3vcKzOzL6BOCxaXghThcKVUcfs";
    }

    @Override
    public void onUpdateReceived(Update update) {
        CallbackQuery query = update.getCallbackQuery();

        Message message = update.getMessage();


        SendMessage sendMessage = new SendMessage();



        sendMessage.setText("Hello user. I received your message '"
                + message.getText()
                + "', but now i cant to do something with it");
        sendMessage.setChatId(String.valueOf(message.getChatId()));


        if (message.getText().equals("/start")) {
            String text = "Welcome to the Exclusive bot.";
            text += "Choose your meal of the day \n";
            text += "Breakfast\n";
            text += "Dinner\n";
            text += "Supper\n";
            text += "Lunch\n";


            sendMessage.enableMarkdown(true);
            ReplyKeyboardMarkup replyKeyboardMarkup = getMenuKeyboard();
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
            sendMessage.setText(text);

        }

        if (message.getText().equals("supper") || message.getText().equals("lunch")) {
            String text = message.getText() + " menu in progress..";
            sendMessage.setText(text);
        }

        if (message.getText().equals("breakfast")) {
            StringBuilder builder = new StringBuilder();

            builder.append("Breakfast menu").append(System.lineSeparator());
            builder.append("1. Coke").append(System.lineSeparator());
            builder.append("2. Tea").append(System.lineSeparator());
            builder.append("3. Cake").append(System.lineSeparator());


            sendMessage.setText(builder.toString());
        }
        if (message.getText().equals("dinner")) {
            StringBuilder builder = new StringBuilder();

            builder.append("Dinner menu").append(System.lineSeparator());
            builder.append("1. Soup").append(System.lineSeparator());
            builder.append("2. Cabbage rolls").append(System.lineSeparator());
            builder.append("3. Roast beef").append(System.lineSeparator());


            sendMessage.setText(builder.toString());
        }

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private ReplyKeyboardMarkup getMenuKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("breakfast");
        keyboardRow.add("dinner");
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add("lunch");
        keyboardSecondRow.add("supper");

        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardSecondRow);

        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;



    }
}
