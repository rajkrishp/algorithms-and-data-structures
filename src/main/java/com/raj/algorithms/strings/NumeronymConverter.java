package com.raj.algorithms.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Utility methods for converting strings to numeronyms.
 *
 * <p>A numeronym is a compact representation of a word where the middle characters are replaced
 * by their count. Example: {@code internationalization -> i18n}.</p>
 *
 * <h2>Rules used by this implementation</h2>
 * <ul>
 *   <li>If a token has length 0..3, it is returned unchanged.</li>
 *   <li>If a token has length 4+, it is converted to: first-char + (length-2) + last-char.</li>
 *   <li>For full text conversion, whitespace and punctuation are preserved exactly.</li>
 *   <li>Only contiguous letter/digit sequences are converted as tokens.</li>
 * </ul>
 */
public final class NumeronymConverter {

    private NumeronymConverter() {
        // Utility class; prevent instantiation.
    }

    /**
     * Converts a single token (word-like sequence) into its numeronym form.
     *
     * @param token token to convert; must not be null
     * @return numeronym for length >= 4, otherwise original token
     * @throws NullPointerException if token is null
     */
    public static String toNumeronymToken(String token) {
        Objects.requireNonNull(token, "token must not be null");

        if (token.length() <= 3) {
            return token;
        }

        int middleCount = token.length() - 2;
        return token.charAt(0) + String.valueOf(middleCount) + token.charAt(token.length() - 1);
    }

    /**
     * Converts all alphanumeric tokens in input text into numeronyms while preserving separators.
     *
     * <p>Example:</p>
     * <pre>{@code
     * Input : "internationalization and localization"
     * Output: "i18n and l10n"
     * }</pre>
     *
     * @param input text to convert; must not be null
     * @return converted text with punctuation/whitespace preserved
     * @throws NullPointerException if input is null
     */
    public static String toNumeronymText(String input) {
        Objects.requireNonNull(input, "input must not be null");

        StringBuilder out = new StringBuilder(input.length());
        int i = 0;

        while (i < input.length()) {
            char c = input.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                int start = i;
                while (i < input.length() && Character.isLetterOrDigit(input.charAt(i))) {
                    i++;
                }
                String token = input.substring(start, i);
                out.append(toNumeronymToken(token));
            } else {
                out.append(c);
                i++;
            }
        }

        return out.toString();
    }

    /**
     * Generates all possible numeronyms of a token by varying the number of preserved prefix/suffix
     * characters.
     *
     * <p>For "localization", one possible output includes: l10n, lo8on, loc6ion, ...</p>
     *
     * @param token token to analyze; must not be null
     * @return list of all possible numeronyms (possibly empty if token length < 3)
     */
    public static List<String> allNumeronyms(String token) {
        Objects.requireNonNull(token, "token must not be null");

        List<String> result = new ArrayList<>();
        int n = token.length();

        // Need at least one hidden character to form a numeronym variation.
        for (int prefixLen = 1; prefixLen < n - 1; prefixLen++) {
            for (int suffixStart = prefixLen + 1; suffixStart < n; suffixStart++) {
                int hiddenCount = suffixStart - prefixLen;
                if (hiddenCount < 1) {
                    continue;
                }
                String numeronym = token.substring(0, prefixLen)
                        + hiddenCount
                        + token.substring(suffixStart);
                result.add(numeronym);
            }
        }

        return result;
    }

    /**
     * CLI entry point.
     *
     * <p>Usage:</p>
     * <pre>{@code
     * java ... NumeronymConverter "internationalization and localization"
     * }</pre>
     *
     * @param args command-line args; first argument is treated as input text
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: NumeronymConverter \"your text here\"");
            return;
        }

        String input = String.join(" ", args);
        String output = toNumeronymText(input);

        System.out.println("Input : " + input);
        System.out.println("Output: " + output);
    }
}
