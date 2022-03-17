package com.baudoliver7.impl;

import com.baudoliver7.api.NumberInLetters;

/**
 * Transforms number into letters in French.
 * @see <a href="https://codes-sources.commentcamarche.net/source/view/100840/1351639#browser">Documentation</a>
 * @since 0.1
 */
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
		final String[] n1= {"", " Un", " Deux", " Trois", " Quatre", " Cinq", " Six", " Sept", " Huit", " Neuf", " Dix", " Onze", " Douze", " Treize", " Quatorze", " Quinze", " Seize", " Dix-sept", " Dix-huit", " Dix-neuf"},
                n70= {" Soixante et Onze", " Soixante-Douze", " Soixante-Treize", " Soixante-Quatorze", " Soixante-Quinze", " Soixante-Seize", " Soixante-Dix-sept", " Soixante-Dix-huit", " Soixante-Dix-neuf"},
                n90= {" Quatre-vingt-Onze", " Quatre-vingt-Douze", " Quatre-vingt-Treize", " Quatre-vingt-Quatorze", " Quatre-vingt-Quinze", " Quatre-vingt-Seize", " Quatre-vingt-Dix-sept", " Quatre-vingt-Dix-huit", " Quatre-vingt-Dix-neuf"},
                n10= {"", " Dix", " Vingt", " Trente", " Quarante", " Cinquante", " Soixante", " Soixante-Dix", " Quatre-vingt", " Quatre-vingt-Dix"},
                n1000= {"", " Mille", " Million", " Milliard", " Billion", " Billiard"};
       String result= "";
       final String numberstr = number.toString();
       int rang = ((numberstr.length()+ 2)/ 3);
       String un, dix;
       while (rang > 0)    {
    	   String tranche;
           if (result == "") {
               tranche= numberstr.substring(0, ((numberstr.length() + 2)% 3) + 1);
               while (tranche.length() < 3)
               tranche = "0"+ tranche;
           } else {
               tranche = numberstr.substring(numberstr.length() - (rang * 3), numberstr.length()- ((rang- 1) * 3));
           }
           String dec = tranche;
           dec= dec.substring(1, 3);
           if (dec.length()== 1) {
               un= dec;
               dix= "0";
           }
           else {
               un= dec.substring(1);
               dix= dec.substring(0, 1);
           }
           String cent = tranche;
           cent= cent.substring(0, 1);
           switch (Integer.parseInt(cent)) {
               case 0:
               break;
               case 1: result+= " Cent";
               break;
               default: result+= n1[Integer.parseInt(cent)]+ " Cent";
           }
           switch (Integer.parseInt(dec)) {
               case 0:
                   if (!cent.equals("0"))
                       result+= n1000[rang- 1];
               break;
               case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 11: case 12: case 13: case 14: case 15: case 16: case 17: case 18: case 19:
                   result+= n1[Integer.parseInt(dec)]+ n1000[rang- 1];
               break;
               case 71: case 72: case 73: case 74: case 75: case 76: case 77: case 78: case 79:
                   result+= n70[Integer.parseInt(un)- 1]+ n1000[rang- 1];
               break;
               case 91: case 92: case 93: case 94: case 95: case 96: case 97: case 98: case 99:
                   result+= n90[Integer.parseInt(un)- 1]+ n1000[rang- 1];
               break;
               default:
                   if ((!dix.equals("0"))&&(un.equals("1")))
                       result+= n10[Integer.parseInt(dix)]+ " et Un"+ n1000[rang- 1];
                   else
                       result+= n10[Integer.parseInt(dix)]+ n1[Integer.parseInt(un)]+ n1000[rang- 1];
           }
           rang--;
       }
       if (result.equals(""))
           result= " Zero";
           
       return result.trim();
	}

}
