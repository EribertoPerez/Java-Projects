package com.bobbyscompany.mortgagecalc;

public class TextBox {
    public String text = "";
        public static void main(String[] args) {
            var textBox1 = new TextBox();
            textBox1.setText("Box 1");
            System.out.println(textBox1.text.toLowerCase());

            var textBox2 = new TextBox();
            textBox2.setText("Box 2");
            System.out.println(textBox2.text.toUpperCase());
        }
        public void setText(String text) {
        this.text = text;
    }
        public void clear() {
        text = "";
    }
    }