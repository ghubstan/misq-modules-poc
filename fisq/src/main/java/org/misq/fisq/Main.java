package org.misq.fisq;


import org.misq.list.LinkedList;

import static org.misq.fisq.MessageUtils.getMessage;
import static org.misq.utilities.StringUtils.join;
import static org.misq.utilities.StringUtils.split;

public class Main {
    public static void main(String[] args) {
        LinkedList tokens;
        tokens = split(getMessage());
        System.out.println(join(tokens));
    }
}
