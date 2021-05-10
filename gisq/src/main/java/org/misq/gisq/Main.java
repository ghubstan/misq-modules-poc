package org.misq.gisq;


import lombok.extern.slf4j.Slf4j;
import org.misq.list.LinkedList;

import static org.misq.gisq.MessageUtils.getMessage;
import static org.misq.utilities.StringUtils.join;
import static org.misq.utilities.StringUtils.split;

@Slf4j
public class Main {
    public static void main(String[] args) {
        LinkedList tokens;
        tokens = split(getMessage());
        log.info(join(tokens));
    }
}
