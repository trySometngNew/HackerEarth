/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package org.sourabh.internet.archieves;

import org.sourabh.internet.archieves.utils.CommonUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sourabh
 */

public class HackerEarth {

        static LinkedList<Long> primeSieve;
        static long primeSieveLimit;

//    static {
//        try {
//            long timer_start = System.nanoTime();
//            HackerEarth.primeSieve = new LinkedList<>();
//            primeNumberEratosthenesList(20L);
//            System.out.println("Sieve Time: " + ((System.nanoTime() - timer_start) / (1000)) + " Usec.");
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(HackerEarth.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(HackerEarth.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
        /**
         * @param args the command line arguments
         * @throws java.lang.InterruptedException
         */
        public static void main(String[] args) throws InterruptedException, IOException {
            long timer_start = System.nanoTime();
//        BufferedReader inStream = new BufferedReader(new InputStreamReader(System.in));
//        String input = inStream.readLine();
//        inStream.close();
//        int upperLimit = 0;
//        if (input != null) {
//            upperLimit = Integer.parseInt(input);
//        }
//        upperLimit = 1000000;
            System.out.println(prjEule_Prob_15() + " sum of all primes under 2 Million !!");

            System.out.println("Time: " + ((System.nanoTime() - timer_start) / (1000)) + " Usec.");
        }

        /**
         * Lattice paths Problem 15 Starting in the top left corner of a 2×2 grid,
         * and only being able to move to the right and down, there are exactly 6
         * routes to the bottom right corner. // Refer diagram
         *
         * How many such routes are there through a 20×20 grid?
         *
         * @return
         */
        static long prjEule_Prob_15() {
            long paths = 1;
            byte gridSize = 20;
            long[][] gridArr = new long[gridSize + 1][gridSize + 1];
            // Initialize boundary conditions
            for (int index = 0; index < gridSize; index++) {
                gridArr[index][gridSize] = 1;
                gridArr[gridSize][index] = 1;
            }
            // Now use previous boundary cpnditions
            for (int rowIndex = (gridSize - 1); rowIndex >= 0; rowIndex--) {
                for (int columnIndex = (gridSize - 1); columnIndex >= 0; columnIndex--) {
                    gridArr[rowIndex][columnIndex] = gridArr[rowIndex + 1][columnIndex] + gridArr[rowIndex][columnIndex+1];
                }
            }
            return paths=gridArr[0][0];
        }

        /**
         * Longest Collatz sequence Problem 14 The following iterative sequence is
         * defined for the set of positive integers:
         *
         * n ? n/2 (n is even) n ? 3n + 1 (n is odd)
         *
         * Using the rule above and starting with 13, we generate the following
         * sequence:
         *
         * 13 ? 40 ? 20 ? 10 ? 5 ? 16 ? 8 ? 4 ? 2 ? 1 It can be seen that this
         * sequence (starting at 13 and finishing at 1) contains 10 terms. Although
         * it has not been proved yet (Collatz Problem), it is thought that all
         * starting numbers finish at 1.
         *
         * Which starting number, under one million, produces the longest chain?
         *
         * NOTE: Once the chain starts the terms are allowed to go above one
         * million.
         *
         * @return
         */
        static int prjEule_Prob_14(int upperLimit) {
            int startingNum = 0;
            int longestCollatzLength = 0;
            for (int index = 2; index < upperLimit; index++) {
                long number = index;
                int tempCount = 0;
                while (number != 1) {
                    if ((number & 1) == 0) {
                        number /= 2;
                        tempCount++;
                    } else {
                        number = (3 * number) + 1;
                        tempCount++;
                    }
                }
                if (tempCount > longestCollatzLength) {
                    longestCollatzLength = tempCount;
                    startingNum = index;
                }
            }
            return startingNum;
        }

        static int prjEule_Prob_13() {
            String str = "37107287533902102798797998220837590246510135740250\n"
                    + "46376937677490009712648124896970078050417018260538\n"
                    + "74324986199524741059474233309513058123726617309629\n"
                    + "91942213363574161572522430563301811072406154908250\n"
                    + "23067588207539346171171980310421047513778063246676\n"
                    + "89261670696623633820136378418383684178734361726757\n"
                    + "28112879812849979408065481931592621691275889832738\n"
                    + "44274228917432520321923589422876796487670272189318\n"
                    + "47451445736001306439091167216856844588711603153276\n"
                    + "70386486105843025439939619828917593665686757934951\n"
                    + "62176457141856560629502157223196586755079324193331\n"
                    + "64906352462741904929101432445813822663347944758178\n"
                    + "92575867718337217661963751590579239728245598838407\n"
                    + "58203565325359399008402633568948830189458628227828\n"
                    + "80181199384826282014278194139940567587151170094390\n"
                    + "35398664372827112653829987240784473053190104293586\n"
                    + "86515506006295864861532075273371959191420517255829\n"
                    + "71693888707715466499115593487603532921714970056938\n"
                    + "54370070576826684624621495650076471787294438377604\n"
                    + "53282654108756828443191190634694037855217779295145\n"
                    + "36123272525000296071075082563815656710885258350721\n"
                    + "45876576172410976447339110607218265236877223636045\n"
                    + "17423706905851860660448207621209813287860733969412\n"
                    + "81142660418086830619328460811191061556940512689692\n"
                    + "51934325451728388641918047049293215058642563049483\n"
                    + "62467221648435076201727918039944693004732956340691\n"
                    + "15732444386908125794514089057706229429197107928209\n"
                    + "55037687525678773091862540744969844508330393682126\n"
                    + "18336384825330154686196124348767681297534375946515\n"
                    + "80386287592878490201521685554828717201219257766954\n"
                    + "78182833757993103614740356856449095527097864797581\n"
                    + "16726320100436897842553539920931837441497806860984\n"
                    + "48403098129077791799088218795327364475675590848030\n"
                    + "87086987551392711854517078544161852424320693150332\n"
                    + "59959406895756536782107074926966537676326235447210\n"
                    + "69793950679652694742597709739166693763042633987085\n"
                    + "41052684708299085211399427365734116182760315001271\n"
                    + "65378607361501080857009149939512557028198746004375\n"
                    + "35829035317434717326932123578154982629742552737307\n"
                    + "94953759765105305946966067683156574377167401875275\n"
                    + "88902802571733229619176668713819931811048770190271\n"
                    + "25267680276078003013678680992525463401061632866526\n"
                    + "36270218540497705585629946580636237993140746255962\n"
                    + "24074486908231174977792365466257246923322810917141\n"
                    + "91430288197103288597806669760892938638285025333403\n"
                    + "34413065578016127815921815005561868836468420090470\n"
                    + "23053081172816430487623791969842487255036638784583\n"
                    + "11487696932154902810424020138335124462181441773470\n"
                    + "63783299490636259666498587618221225225512486764533\n"
                    + "67720186971698544312419572409913959008952310058822\n"
                    + "95548255300263520781532296796249481641953868218774\n"
                    + "76085327132285723110424803456124867697064507995236\n"
                    + "37774242535411291684276865538926205024910326572967\n"
                    + "23701913275725675285653248258265463092207058596522\n"
                    + "29798860272258331913126375147341994889534765745501\n"
                    + "18495701454879288984856827726077713721403798879715\n"
                    + "38298203783031473527721580348144513491373226651381\n"
                    + "34829543829199918180278916522431027392251122869539\n"
                    + "40957953066405232632538044100059654939159879593635\n"
                    + "29746152185502371307642255121183693803580388584903\n"
                    + "41698116222072977186158236678424689157993532961922\n"
                    + "62467957194401269043877107275048102390895523597457\n"
                    + "23189706772547915061505504953922979530901129967519\n"
                    + "86188088225875314529584099251203829009407770775672\n"
                    + "11306739708304724483816533873502340845647058077308\n"
                    + "82959174767140363198008187129011875491310547126581\n"
                    + "97623331044818386269515456334926366572897563400500\n"
                    + "42846280183517070527831839425882145521227251250327\n"
                    + "55121603546981200581762165212827652751691296897789\n"
                    + "32238195734329339946437501907836945765883352399886\n"
                    + "75506164965184775180738168837861091527357929701337\n"
                    + "62177842752192623401942399639168044983993173312731\n"
                    + "32924185707147349566916674687634660915035914677504\n"
                    + "99518671430235219628894890102423325116913619626622\n"
                    + "73267460800591547471830798392868535206946944540724\n"
                    + "76841822524674417161514036427982273348055556214818\n"
                    + "97142617910342598647204516893989422179826088076852\n"
                    + "87783646182799346313767754307809363333018982642090\n"
                    + "10848802521674670883215120185883543223812876952786\n"
                    + "71329612474782464538636993009049310363619763878039\n"
                    + "62184073572399794223406235393808339651327408011116\n"
                    + "66627891981488087797941876876144230030984490851411\n"
                    + "60661826293682836764744779239180335110989069790714\n"
                    + "85786944089552990653640447425576083659976645795096\n"
                    + "66024396409905389607120198219976047599490197230297\n"
                    + "64913982680032973156037120041377903785566085089252\n"
                    + "16730939319872750275468906903707539413042652315011\n"
                    + "94809377245048795150954100921645863754710598436791\n"
                    + "78639167021187492431995700641917969777599028300699\n"
                    + "15368713711936614952811305876380278410754449733078\n"
                    + "40789923115535562561142322423255033685442488917353\n"
                    + "44889911501440648020369068063960672322193204149535\n"
                    + "41503128880339536053299340368006977710650566631954\n"
                    + "81234880673210146739058568557934581403627822703280\n"
                    + "82616570773948327592232845941706525094512325230608\n"
                    + "22918802058777319719839450180888072429661980811197\n"
                    + "77158542502016545090413245809786882778948721859617\n"
                    + "72107838435069186155435662884062257473692284509516\n"
                    + "20849603980134001723930671666823555245252804609722\n"
                    + "53503534226472524250874054075591789781264330331690";
            String[] strArr = str.split("\n");
            BigInteger big = new BigInteger("0");
            for (String string : strArr) {
                big = big.add(new BigInteger(string));
            }
            String sr = big.toString().substring(0, 10);
            return Integer.parseInt(sr);
        }

        /**
         * Highly divisible triangular number Problem 12 The sequence of triangle
         * numbers is generated by adding the natural numbers. So the 7th triangle
         * number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would
         * be:
         *
         * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
         *
         * Let us list the factors of the first seven triangle numbers:
         *
         * 1: 1 3: 1,3 6: 1,2,3,6 10: 1,2,5,10 15: 1,3,5,15 21: 1,3,7,21 28:
         * 1,2,4,7,14,28 We can see that 28 is the first triangle number to have
         * over five divisors.
         *
         * What is the value of the first triangle number to have over five hundred
         * divisors?
         *
         * @return
         */
        static int prjEule_Prob_12() {
            int triangleNum = 0;
            int i = 1;
            while (CommonUtils.numberOfDivisors(triangleNum) < 500) {
                triangleNum += i;
                i++;
            }
            return triangleNum;
        }

        /**
         * Largest product in a grid Problem 11 In the 20×20 grid below, four
         * numbers along a diagonal line have been marked in red.
         *
         * 08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 49 49 99 40
         * 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 81 49 31 73 55 79 14 29
         * 93 71 40 67 53 88 30 03 49 13 36 65 52 70 95 23 04 60 11 42 69 24 68 56
         * 01 32 56 71 37 02 36 91 22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28
         * 66 33 13 80 24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
         * 32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 67 26 20 68
         * 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 24 55 58 05 66 73 99 26
         * 97 17 78 78 96 83 14 88 34 89 63 72 21 36 23 09 75 00 76 44 20 45 35 14
         * 00 61 33 97 34 31 33 95 78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14
         * 09 53 56 92 16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
         * 86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 19 80 81 68
         * 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 04 52 08 83 97 35 99 16
         * 07 97 57 32 16 26 26 79 33 27 98 66 88 36 68 87 57 62 20 72 03 46 33 67
         * 46 55 12 32 63 93 53 69 04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32
         * 40 62 76 36 20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
         * 20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 01 70 54 71
         * 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48 The product of these
         * numbers is 26 × 63 × 78 × 14 = 1788696.
         *
         * What is the greatest product of four adjacent numbers in the same
         * direction (up, down, left, right, or diagonally) in the 20×20 grid?
         *
         * 70600674 | 16848 Usec
         *
         * @return
         */
        static int prjEule_Prob_11() {
            String str = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08"
                    + " 49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00"
                    + " 81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65"
                    + " 52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91"
                    + " 22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80"
                    + " 24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50"
                    + " 32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70"
                    + " 67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21"
                    + " 24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72"
                    + " 21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95"
                    + " 78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92"
                    + " 16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57"
                    + " 86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58"
                    + " 19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40"
                    + " 04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66"
                    + " 88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69"
                    + " 04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36"
                    + " 20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16"
                    + " 20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54"
                    + " 01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";
            String[] strArr = str.split(" ");
            int[][] numArr = new int[20][20];
            int numArrIndex = 0;
            // Prepare integer Array
            int innerIndex = 0;
            for (String strArr1 : strArr) {
                numArr[numArrIndex][innerIndex] = Integer.parseInt(strArr1);
                if (innerIndex < 20) {
                    innerIndex++;
                }
                if (innerIndex == 20) {
                    numArrIndex++;
                    innerIndex = 0;
                }
            }

            // Parse numArr in three ways: Length, breadth, diagonal
            int product = 0;
            int tempProduct = 1;
            final int numsForProduct = 4;
            for (int rowIndex = 0; rowIndex < numArr.length; rowIndex++) {
                for (int columnIndex = 0; columnIndex < numArr[rowIndex].length; columnIndex++) {
                    if (rowIndex < (numArr.length - numsForProduct)) {
                        tempProduct = numArr[rowIndex][columnIndex];
                        for (int count = 1; count < numsForProduct; count++) {
                            tempProduct *= numArr[rowIndex + count][columnIndex];
                        }
                        if (tempProduct > product) {
                            product = tempProduct;
                        }
                    }

                    // Horz parsing
                    if (columnIndex < (numArr[rowIndex].length - numsForProduct)) {
                        tempProduct = numArr[rowIndex][columnIndex];
                        for (int count = 1; count < numsForProduct; count++) {
                            tempProduct *= numArr[rowIndex][columnIndex + count];
                        }
                        if (tempProduct > product) {
                            product = tempProduct;
                        }
                    }

                    // Top Left diagonal parsing
                    if ((columnIndex < (numArr[rowIndex].length - numsForProduct))
                            && (rowIndex < (numArr.length - numsForProduct))) {
                        tempProduct = numArr[rowIndex][columnIndex];
                        for (int count = 1; count < numsForProduct; count++) {
                            tempProduct *= numArr[rowIndex + count][columnIndex + count];
                        }
                        if (tempProduct > product) {
                            product = tempProduct;
                        }
                    }

                    // Top Right diagonal parsing
                    if ((columnIndex >= numsForProduct) && (rowIndex < (numArr.length - numsForProduct))) {
                        tempProduct = numArr[rowIndex][columnIndex];
                        for (int count = 1; count < numsForProduct; count++) {
                            tempProduct *= numArr[rowIndex + count][columnIndex - count];
                        }
                        if (tempProduct > product) {
                            product = tempProduct;
                        }
                    }
                }
            }
            return product;
        }

        /**
         * Summation of primes Problem 10 The sum of the primes below 10 is 2 + 3 +
         * 5 + 7 = 17.
         *
         * Find the sum of all the primes below two million. 142913828922 | 4677949
         * Usec
         *
         * @return
         */
        static long prjEule_Prob_10() {
            long summationOfPrimes = 2;
            int upperLimit = 2000000;
            //  142913828922 | 142913828922
            for (int index = 3; index < upperLimit; index += 2) {
                boolean isPrime = true;
                for (int i = 3; (i * i) <= index; i += 2) {
                    if (index % i == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    summationOfPrimes += index;
                }
            }
            return summationOfPrimes;
        }

        /**
         * Problem 9 A Pythagorean triplet is a set of three natural numbers, a < b
         * < c, for which,
         *
         * a2 + b2 = c2 For example, 32 + 42 = 9 + 16 = 25 = 52.
         *
         * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
         * Find the product abc. @return
         */
        static long prjEule_Prob_9() {
            long product = 0;
            int upperLimit = 1000;
            int a = 0, b = 0, c = 0;
            double temp;
            for (a = 1; a < (upperLimit / 3); a++) {
                for (b = a; b < (upperLimit / 2); b++) {
                    c = 1000 - a - b;
                    if (((a * a) + (b * b)) == (c * c)) {
                        product = a * b * c;
                        break;
                    }
                }
                if (product != 0) {
                    break;
                }
            }
            System.out.println("A:B:C - " + a + ":" + b + ":" + c);
            return product;
        }

        /**
         * Largest product in a series Problem 8 Find the greatest product of five
         * consecutive digits in the 1000-digit number.
         *
         * 73167176531330624919225119674426574742355349194934
         * 96983520312774506326239578318016984801869478851843
         * 85861560789112949495459501737958331952853208805511
         * 12540698747158523863050715693290963295227443043557
         * 66896648950445244523161731856403098711121722383113
         * 62229893423380308135336276614282806444486645238749
         * 30358907296290491560440772390713810515859307960866
         * 70172427121883998797908792274921901699720888093776
         * 65727333001053367881220235421809751254540594752243
         * 52584907711670556013604839586446706324415722155397
         * 53697817977846174064955149290862569321978468622482
         * 83972241375657056057490261407972968652414535100474
         * 82166370484403199890008895243450658541227588666881
         * 16427171479924442928230863465674813919123162824586
         * 17866458359124566529476545682848912883142607690042
         * 24219022671055626321111109370544217506941658960408
         * 07198403850962455444362981230987879927244284909188
         * 84580156166097919133875499200524063689912560717606
         * 05886116467109405077541002256983155200055935729725
         * 71636269561882670428252483600823257530420752963450
         *
         * 38286 Usec | 40824
         */
        static long prjEule_Prob_8() {
            String str = "73167176531330624919225119674426574742355349194934"
                    + "96983520312774506326239578318016984801869478851843"
                    + "85861560789112949495459501737958331952853208805511"
                    + "12540698747158523863050715693290963295227443043557"
                    + "66896648950445244523161731856403098711121722383113"
                    + "62229893423380308135336276614282806444486645238749"
                    + "30358907296290491560440772390713810515859307960866"
                    + "70172427121883998797908792274921901699720888093776"
                    + "65727333001053367881220235421809751254540594752243"
                    + "52584907711670556013604839586446706324415722155397"
                    + "53697817977846174064955149290862569321978468622482"
                    + "83972241375657056057490261407972968652414535100474"
                    + "82166370484403199890008895243450658541227588666881"
                    + "16427171479924442928230863465674813919123162824586"
                    + "17866458359124566529476545682848912883142607690042"
                    + "24219022671055626321111109370544217506941658960408"
                    + "07198403850962455444362981230987879927244284909188"
                    + "84580156166097919133875499200524063689912560717606"
                    + "05886116467109405077541002256983155200055935729725"
                    + "71636269561882670428252483600823257530420752963450";
//        str = "0588611";
            long product = 1;
            long tempProd;
            for (int index = 0; (index + 5) <= str.length(); index++) {
                String string = str.substring(index, (index + 5));
                tempProd = 1;
                for (int innerIndex = 0; innerIndex < string.length(); innerIndex++) {
                    tempProd *= Integer.parseInt(string.substring(innerIndex, (innerIndex + 1)));
                }
                if (tempProd > product) {
                    product = tempProd;
                }
            }
            return product;
        }

        /**
         * 10001st prime Problem 7 By listing the first six prime numbers: 2, 3, 5,
         * 7, 11, and 13, we can see that the 6th prime is 13.
         *
         * What is the 10 001st prime number? 327172 Usec
         *
         * @return
         */
        static long prjEule_Prob_7() {
            long desiredPrime = 2;
            int desiredPrimeLimit = 10000;
            int primeFound = 1;
            for (int index = 3; primeFound <= desiredPrimeLimit; index += 2) {
                if (CommonUtils.isPrimeNumber(index)) {
                    desiredPrime = index;
                    primeFound++;
                }
            }

            return desiredPrime;
        }

        /**
         * Sum square difference Problem 6 The sum of the squares of the first ten
         * natural numbers is,
         *
         * 12 + 22 + ... + 102 = 385 The square of the sum of the first ten natural
         * numbers is,
         *
         * (1 + 2 + ... + 10)2 = 552 = 3025 Hence the difference between the sum of
         * the squares of the first ten natural numbers and the square of the sum is
         * 3025 - 385 = 2640.
         *
         * Find the difference between the sum of the squares of the first one
         * hundred natural numbers and the square of the sum.
         *
         * @return
         */
        static long prjEule_Prob_6() {
            long diffrence = 0;
            int upperLimit = 100;
            long sqareOfSums = 0;
            long sumOfSqaures = 0;
            for (int index = 1; index <= upperLimit; index++) {
                sqareOfSums += index;
                sumOfSqaures += (index * index);
            }
            diffrence = sumOfSqaures - (sqareOfSums * sqareOfSums);
            return Math.abs(diffrence);
        }

        /**
         * Smallest multiple Problem 5 2520 is the smallest number that can be
         * divided by each of the numbers from 1 to 10 without any remainder.
         *
         * What is the smallest positive number that is evenly divisible by all of
         * the numbers from 1 to 20?
         */
        static int prjEule_Prob_5() {
            int upperLimit = 20;
            int[] numberArr = new int[upperLimit];
            for (int index = 1; index <= upperLimit; index++) {
                numberArr[index - 1] = index;
            }
            Integer[] primeArr = CommonUtils.getPrimeNumberArr(upperLimit);
            int[] primeFactorCountArr = new int[primeArr.length];

            for (int number : numberArr) {
                int localCopy = number;
                for (int primeIndex = 0; primeIndex < primeArr.length; primeIndex++) {
                    int primeNum = primeArr[primeIndex];
                    int primeCount = 0;
                    while ((localCopy != 1) && (localCopy % primeNum == 0)) {
                        primeCount++;
                        localCopy /= primeNum;
                    }
                    if (primeFactorCountArr[primeIndex] < primeCount) {
                        primeFactorCountArr[primeIndex] = primeCount;
                    }
                    if (localCopy == 1) {
                        break;
                    }
                }
            }

            // Determine LCM from prime factors obtained;
            int LCM = 1;
            for (int index = 0; index < primeArr.length; index++) {
                int prime = primeArr[index];
                if (prime != 0) {
                    LCM = LCM * (primeArr[index] * primeFactorCountArr[index]);
                }
            }
            return 3 * LCM;
        }

        /**
         * Largest palindrome product Problem 4 A palindromic number reads the same
         * both ways. The largest palindrome made from the product of two 2-digit
         * numbers is 9009 = 91 × 99.
         *
         * Find the largest palindrome made from the product of two 3-digit numbers.
         * Time: 36771 Usec.
         *
         * @return
         */
        static int prjEule_Prob_4() {
            int palindrome = -1;

            for (int outerIndex = 999; outerIndex >= 100; outerIndex--) {
                for (int innerIndex = 999; innerIndex >= 100; innerIndex--) {
                    int product = outerIndex * innerIndex;
                    if (product > palindrome) {
                        if (CommonUtils.isPalindrome(product)) {
                            palindrome = product;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            return palindrome;
        }

        /**
         * Largest prime factor Problem 3 The prime factors of 13195 are 5, 7, 13
         * and 29. What is the largest prime factor of the number 600851475143 ?
         * 6008514753L
         *
         * @return
         */
        static long prjEule_Prob_3(long number) {
            long longestPrimeFac = 0L;
            long index = number - 1;
            if (number < 2L) {
                System.out.println(number + " does NOT have any prime factor");
                return -1;
            } else if ((number & 1) == 1) {
                index--;
            }

            for (long i = index; i > 1; i -= 2) {
                if (number % i == 0) {
                    if (isPrimeSieve(i)) {
                        return longestPrimeFac = i;
                    }
                }
            }
            System.out.println(number + " is a prime number !!");
            return longestPrimeFac = number;
        }

        /**
         * Largest prime factor Problem 3 The prime factors of 13195 are 5, 7, 13
         * and 29. What is the largest prime factor of the number 600851475143 ?
         *
         * @return
         */
        static long prjEule_Prob_2() {
            long sum = 0;
            int prevFibbonaciNum = 1;
            int currentFibbonaciNum = 2;
            int evenFibCount = 0;
            while (currentFibbonaciNum <= 4000000) {
                if ((currentFibbonaciNum & 1) == 1) {
                    sum += currentFibbonaciNum;
                    evenFibCount++;
                }
                int interimFibbonaciNum = currentFibbonaciNum;
                currentFibbonaciNum += prevFibbonaciNum;
                prevFibbonaciNum = interimFibbonaciNum;
            }
            System.out.println("EvenFibCount: " + evenFibCount);
            return sum;
        }

        static long prjEule_Prob_1_AltSoln_1(int number) {
            long sum = 0;
            Set<Long> primeFactors = new TreeSet<>();
            int i = 1;
            long factorOf = 3 * i++;
            do {
                primeFactors.add(factorOf);
//        System.out.println("factorOf3: " + factorOf3);
                factorOf = 3 * i++;
            } while (factorOf < number);
            i = 1;
            factorOf = 5 * i++;
            do {
                primeFactors.add(factorOf);
//        System.out.println("factorOf3: " + factorOf3);
                factorOf = 5 * i++;
            } while (factorOf < number);
            Iterator<Long> iPrime = primeFactors.iterator();
            while (iPrime.hasNext()) {
                sum += iPrime.next();
            }
            return sum;
        }

        static long prjEule_Prob_1_AltSoln(int number) {
            long sum = 0;
            for (int i = 1; i < number; i++) {
                if ((i % 3 == 0) || (i % 5 == 0)) {
                    sum += i;
                }
            }
            return sum;
        }

        /**
         * If we list all the natural numbers below 10 that are multiples of 3 or 5,
         * we get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of
         * all the multiples of 3 or 5 below 1000. uses multiple threads &
         * synchronization
         *
         * @param number
         * @return
         */
        static long prjEuler_Prob_1(int number) throws InterruptedException {

            long sum = 0;
            int i = 1;
            FactorOfLimit he = new FactorOfLimit(3, number);
            Thread t = new Thread(he);
            t.start();
            he = new FactorOfLimit(5, number);
            Thread t2 = new Thread(he);
            t2.start();
            t.join();
            t2.join();
            Set<Long> primeFactors = FactorOfLimit.primeFactors;
//        i = 1;
//        factorOf5 = 5 * i++;
//        do {
//            primeFactors.add(factorOf5);
////        System.out.println("factorOf5: " + factorOf5);
//            factorOf5 = 5 * i++;
//        } while (factorOf5 < number);
            Iterator<Long> iPrime = primeFactors.iterator();
            while (iPrime.hasNext()) {
                sum += iPrime.next();
            }
            return sum;
        }

        //incomplete
        static String luckyString(String number) {
            BigInteger num = new BigInteger(number);
            List<BigInteger> numList = new ArrayList<>();
            String lucky_1 = "4";
            String lucky_2 = "7";

            int count = 0;

            int numberInt = Integer.parseInt(number);
            while (numberInt > numList.size()) {

            }

            return null;
        }

        /**
         * Determines if given number is prime and if it contains prime number of
         * prime digits
         *
         * @param number
         * @return
         */
        static Integer[] isOptimusPrime(long number) {
            if (CommonUtils.isPrimeNumber(number)) {
                String str = String.valueOf(number);
                int primeCounter = 0;
                List<Integer> primeNos = new LinkedList<>();
                for (int index = 0; index < str.length(); index++) {
                    int digit_1 = Character.digit(str.charAt(index), 10);
                    if (CommonUtils.isPrimeNumber(digit_1)) {
                        primeCounter++;
                        primeNos.add(digit_1);
                    }
                }
                if (CommonUtils.isPrimeNumber(primeCounter)) {
                    return primeNos.toArray(new Integer[primeNos.size()]);
                } else {
                    System.out.println(number + " is a prime number.");
                    return null;
                }
            } else {
                System.out.println(number + " is NOT a prime number.");
                return null;
            }
        }

        static boolean isPrimeSieve(long number) {
            if (number <= 1) {
                return false;
            } else if ((number & 1) == 0) {
                return false;
            } else {
                if (HackerEarth.primeSieveLimit < number) {
                    try {
                        primeNumberEratosthenesList(number);
                    } catch (IOException ex) {
                        Logger.getLogger(HackerEarth.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                return HackerEarth.primeSieve.contains(number);
            }
        }

        static void primeNumberEratosthenesList(long number) throws FileNotFoundException, IOException {
            // Read PrimeSieve.txt file to check if already present
            File file = new File("D:\\docx\\PrimeSieve.txt");
//        long prevPrimeLimit = -1;
            if ((file.exists() && (file.length() > 0))) {
                BufferedReader fileStream = new BufferedReader(new FileReader(file));
                String readLine = fileStream.readLine();
                if (readLine.contains("// Contains Primes till ")) {
                    HackerEarth.primeSieveLimit = Long.valueOf(readLine.split(":")[1]);
                    if (HackerEarth.primeSieveLimit >= number) {
                        // Add all prime numbers to list
                        readLine = fileStream.readLine();
                        while (readLine != null) {
                            HackerEarth.primeSieve.add(Long.valueOf(readLine));
                            readLine = fileStream.readLine();
                        }
                    } else {

                        // Generate & Add extra prime numbers to list
//                    readLine = fileStream.readLine();
//                    while ((readLine != null) && (!readLine.isEmpty())) {
//                        HackerEarth.primeSieve.add(Long.valueOf(readLine));
//                        readLine = fileStream.readLine();
//                    }
                        // Generate primes from previous prime limit of file
                        // to current number inclusive and store the same.
                        LinkedList<Long> nonPrimes = new LinkedList<>();
//                    LinkedList<Long> primes = new LinkedList<>();
                        nonPrimes.addAll(HackerEarth.primeSieve);
                        long index = HackerEarth.primeSieveLimit + 1;
                        if ((index & 1) != 1) {
                            index++;
                        }
                        for (; index <= number; index += 2) {
                            nonPrimes.add(index);
                        }
                        file = new File("D:\\docx\\PrimeSieve.txt");
//                    System.out.println("File rename: " + file.renameTo(new File("D:\\docx\\PrimeSieve_" + prevPrimeLimit + ".txt")));
//                    System.out.println("File create: " + file.createNewFile());
//                    HackerEarth.primeSieve.clear();
//                    System.out.println("File exists: " + file.exists());
                        BufferedWriter fileStream_out = new BufferedWriter(new FileWriter(file));
                        fileStream_out.write("// Contains Primes till :" + number);
                        System.out.println("isPrime: " + number);
                        fileStream_out.newLine();
                        while (nonPrimes.size() > 0) {
                            long nextPrime = nonPrimes.remove();
                            if (nextPrime != 2) {
                                for (long i = nextPrime * nextPrime; i <= number; i += nextPrime) {
                                    nonPrimes.removeFirstOccurrence(i);
                                }
                            }
                            if (HackerEarth.primeSieveLimit < nextPrime) {
                                HackerEarth.primeSieve.add(nextPrime);
                            }
                            fileStream_out.append(String.valueOf(nextPrime));
                            fileStream_out.newLine();
                        }
                        fileStream_out.flush();
                        fileStream_out.close();
                        HackerEarth.primeSieveLimit = number;
                        System.out.println("Sieve size: " + HackerEarth.primeSieve.size());
                    }
                }
                fileStream.close();
//            HackerEarth.primeSieve.add(Long.parseLong(readLine));
            } else {
                // For first time, generate prime numbers and persist them in PrimeSieve.txt
                LinkedList<Long> nonPrimes = new LinkedList<>();
                LinkedList<Long> primes = new LinkedList<>();
                nonPrimes.add(2L);
                for (long i = 3; i <= number; i += 2) {
                    nonPrimes.add(i);
                }
                file = new File("D:\\docx\\PrimeSieve.txt");
                BufferedWriter fileStream_out = new BufferedWriter(new FileWriter(file));
                fileStream_out.write("// Contains Primes till :" + number);
                fileStream_out.newLine();
                while (nonPrimes.size() > 0) {
                    long nextPrime = nonPrimes.remove();
                    if (nextPrime != 2) {
                        for (long i = nextPrime * nextPrime; i <= number; i += nextPrime) {
                            nonPrimes.removeFirstOccurrence(i);
                        }
                    }
                    HackerEarth.primeSieve.add(nextPrime);
                    fileStream_out.write(String.valueOf(nextPrime));
                    fileStream_out.newLine();
                }
                fileStream_out.flush();
                fileStream_out.close();
                HackerEarth.primeSieveLimit = number;
            }
        }
    }

    class FactorOfLimit implements Runnable {

        public static Set<Long> primeFactors;
        int factorNum;
        long upperLimit;

        static {
            primeFactors = new TreeSet<>();
        }

        FactorOfLimit(int factorNum, long upperLimit) {
            this.factorNum = factorNum;
            this.upperLimit = upperLimit;
        }

        @Override
        public void run() {
            Integer i = 1;
            synchronized (primeFactors) {
                long factorOf = this.factorNum * i++;
                do {
                    primeFactors.add(factorOf);
//        System.out.println("factorOf3: " + factorOf3);
                    factorOf = this.factorNum * i++;
                } while (factorOf < this.upperLimit);
                primeFactors.notify();
                System.gc();
            }
        }
    }