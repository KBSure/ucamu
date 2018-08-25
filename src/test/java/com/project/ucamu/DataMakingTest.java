package com.project.ucamu;

import org.junit.Test;

import java.util.Calendar;

public class DataMakingTest {

    @Test
    public void Board데이터만들기(){
        Calendar date = Calendar.getInstance();
        date.set(2016, 0, 1);
        int month = 0;
        int day = 0;
        String dateString;
        for(int i = 1; i <= 1000; i = i + 2){
            date.add(Calendar.DATE, 1);
            dateString = "'" + date.get(Calendar.YEAR) + "-" + ((month = (date.get(Calendar.MONTH)+1)) < 10 ? "0"+month : month) + "-" + ((day = date.get(Calendar.DATE)) < 10 ? "0"+day : day) + " 07:07:07'";
            String str = "INSERT INTO BOARD(id, title, content_who, content_when, content_where, content_what, content_how, content_why, reg_date, up_date, view, great, USER_id, CATEGORY_id) VALUES(" + i +  ", '간단하게 작성하고 있다" + i + "', '내가', '지금', '유카뮤에서', '게시글을', '간단하게 작성하고 있다.', '당신이 작성 방법을 모를까봐', " + dateString + ", " + dateString + ", " + (1000 + i) + ", " + (1001-i) + ", 1, 1);";
            System.out.println(str);

            date.add(Calendar.DATE, 1);
            dateString = "'" + date.get(Calendar.YEAR) + "-" + ((month = (date.get(Calendar.MONTH)+1)) < 10 ? "0"+month : month) + "-" + ((day = date.get(Calendar.DATE)) < 10 ? "0"+day : day) + " 07:07:07'";
            String str2 = "INSERT INTO BOARD(id, title, content_who, content_when, content_where, content_what, content_how, content_why, reg_date, up_date, view, great, USER_id, CATEGORY_id) VALUES(" + (i+1) +  ", '질서 없이 작성하고 있다" + (i+1) + "', '우리는', '대부분', '커뮤니티에서', '게시글을', '질서 없이 작성하고 있다.', '형식이 정해져 있지 않으니까', " + dateString + ", " + dateString + ", " + (1000 + i-1) + ", " + (1001-i+1) + ", 1, 1);";
            System.out.println(str2);
        }
    }
}
