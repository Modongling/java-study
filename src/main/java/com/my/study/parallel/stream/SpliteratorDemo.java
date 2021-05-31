package com.my.study.parallel.stream;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author mdl
 * @Created 2021/5/30 14:25
 * @Description
 */
public class SpliteratorDemo {
    private static final String WORDS = "Hello world";
    public static int foundWord(String s) {
        int count = 0;
        boolean space = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                space = true;
            } else {
                if (space) {
                    count++;
                }
                space = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(foundWord(WORDS));
        Stream<Character> stream = IntStream.range(0, WORDS.length())
                .mapToObj(WORDS::charAt);
        System.out.println(countWord(stream));
        Spliterator<Character> spliterator = new WordsSpliter(WORDS);
        Stream<Character> characterStream = StreamSupport.stream(spliterator, true);
        System.out.println(countWord(characterStream));
    }

    private static class WordCounter {
        private int counter;
        private boolean lastSpace;

        public WordCounter(int counter, boolean lastSpace) {
            this.counter = counter;
            this.lastSpace = lastSpace;
        }

        public WordCounter accumulate(Character c) {
            if (Character.isWhitespace(c)) {
                return lastSpace ? this : new WordCounter(counter, true);
            } else {
                return lastSpace ? new WordCounter(counter + 1, false) : this;
            }
        }

        public WordCounter combine(WordCounter wordCounter) {
            return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
        }

        public int getCounter() {
            return counter;
        }
    }

    public static int countWord(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
        return wordCounter.getCounter();
    }

    private static class WordsSpliter implements Spliterator<Character> {
        private String string;
        private int curCharAt = 0;

        public WordsSpliter(String string) {
            this.string = string;
        }

        @Override
        public boolean tryAdvance(Consumer<? super Character> action) {
            action.accept(string.charAt(curCharAt++));
            return curCharAt < string.length();
        }

        @Override
        public Spliterator<Character> trySplit() {
            int curSize = string.length() - curCharAt;
            if (curSize < 10) {
                return null;
            }

            for (int i = curSize / 2 + curCharAt; i < string.length() ; i++) {
                if (Character.isWhitespace(string.charAt(i))) {
                    Spliterator<Character> spliterator = new WordsSpliter(string.substring(curCharAt, i));
                    curCharAt = i;
                    return spliterator;
                }
            }
            return null;
        }

        @Override
        public long estimateSize() {
            return string.length() - curCharAt;
        }

        @Override
        public int characteristics() {
            return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
        }
    }
}
