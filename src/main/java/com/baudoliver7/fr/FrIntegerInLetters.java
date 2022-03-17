/*
 * MIT License
 *
 * Copyright (c) 2022 Olivier B. OURA
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.baudoliver7.fr;

import com.baudoliver7.api.NumberInLetters;

/**
 * Transforms number into letters in French.
 * @see <a href="https://codes-sources.commentcamarche.net/source/view/100840/1351639#browser">Documentation</a>
 * @since 0.1
 * @checkstyle MagicNumberCheck (500 lines)
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public final class FrIntegerInLetters implements NumberInLetters {

    /**
     * Number to convert.
     */
    private final Long number;

    /**
     * Ctor.
     * @param number Number to convert.
     */
	public FrIntegerInLetters(final Long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		final String[] n1 = {
            "", " Un", " Deux", " Trois", " Quatre", " Cinq", " Six", " Sept", " Huit",
            " Neuf", " Dix", " Onze", " Douze", " Treize", " Quatorze", " Quinze", " Seize",
            " Dix-sept", " Dix-huit", " Dix-neuf"
        };
        final String[] n70 = {
            " Soixante et Onze", " Soixante-Douze", " Soixante-Treize", " Soixante-Quatorze",
            " Soixante-Quinze", " Soixante-Seize", " Soixante-Dix-sept", " Soixante-Dix-huit",
            " Soixante-Dix-neuf"
        };
        final String[] n90 = {
            " Quatre-vingt-Onze", " Quatre-vingt-Douze", " Quatre-vingt-Treize",
            " Quatre-vingt-Quatorze", " Quatre-vingt-Quinze", " Quatre-vingt-Seize",
            " Quatre-vingt-Dix-sept", " Quatre-vingt-Dix-huit", " Quatre-vingt-Dix-neuf"
        };
        final String[] n10 = {
            "", " Dix", " Vingt", " Trente", " Quarante", " Cinquante", " Soixante",
            " Soixante-Dix", " Quatre-vingt", " Quatre-vingt-Dix"
        };
        final String[] n1000 = {"", " Mille", " Million", " Milliard", " Billion", " Billiard"};
        final StringBuilder result = new StringBuilder();
        final String nbstr = number.toString();
        int rang = (nbstr.length() + 2) / 3;
        String un, dix;
        while (rang > 0) {
            final StringBuilder tranche = new StringBuilder();
            if (result.toString().equals("")) {
                tranche.append(
                    nbstr,
                    0, ((nbstr.length() + 2) % 3) + 1
                );
                while (tranche.length() < 3) {
                    tranche.insert(0, "0");
                }
            } else {
                tranche.append(
                    nbstr,
                    nbstr.length() - (rang * 3),
                    nbstr.length() - ((rang - 1) * 3)
                );
            }
            final String dec = tranche.substring(1, 3);
            if (dec.length() == 1) {
                un = dec;
                dix = "0";
            }
            else {
                un = dec.substring(1);
                dix = dec.substring(0, 1);
            }
            final String cent = tranche.substring(0, 1);
            switch (Integer.parseInt(cent)) {
                case 0:
                break;
                case 1: result.append(" Cent");
                break;
                default: result.append(n1[Integer.parseInt(cent)]).append(" Cent");
            }
            switch (Integer.parseInt(dec)) {
            case 0:
                if (!cent.equals("0")) {
                    result.append(n1000[rang - 1]);
                }
            break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                result.append(n1[Integer.parseInt(dec)]).append(n1000[rang - 1]);
            break;
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
                result.append(n70[Integer.parseInt(un) - 1]).append(n1000[rang - 1]);
            break;
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
                result.append(n90[Integer.parseInt(un) - 1]).append(n1000[rang - 1]);
            break;
            default:
                if ((!dix.equals("0")) && (un.equals("1"))) {
                    result.append(n10[Integer.parseInt(dix)])
                        .append(" et Un")
                        .append(n1000[rang - 1]);
                } else {
                    result.append(n10[Integer.parseInt(dix)])
                        .append(n1[Integer.parseInt(un)])
                        .append(n1000[rang - 1]);
                }
            }
            rang -= 1;
       }
       if (result.equals("")) {
           result.append(" Zero");
       }
       return result.toString().trim();
	}

}
