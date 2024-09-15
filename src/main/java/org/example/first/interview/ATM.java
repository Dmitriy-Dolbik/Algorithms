package org.example.first.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Банкомат.
 * Инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом.
 * При выдаче купюры списываются с баланса банкомата.
 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 */
class ATM {

    private final Map<CoupurType, Integer> coupursInAtm;

    public ATM(Map<CoupurType, Integer> putCoupursToA) {
        this.coupursInAtm = putCoupursToA;
    }

    public Map<CoupurType, Integer> getMoney(int moneySumToGet) {
        Map<CoupurType, Integer> result = new HashMap<>();
        int resultSum = 0;

        for (CoupurType coupurType : CoupurType.values()) {
            int remainSum = moneySumToGet - resultSum;
            if (coupurType.getNomial() > moneySumToGet - resultSum) {
                continue;
            }
            int nominal = coupurType.getNomial();
            int availablecoupurCount = remainSum / nominal;

            int coupurInAtmWithCurrentNominal = coupursInAtm.getOrDefault(coupurType, 0);

            int resulCoupurCountOfConcresteNominal = Math.min(availablecoupurCount, coupurInAtmWithCurrentNominal);

            result.put(coupurType, resulCoupurCountOfConcresteNominal);
            resultSum = resultSum + resulCoupurCountOfConcresteNominal * nominal;
        }

        if (resultSum == moneySumToGet) {
            for(Map.Entry<CoupurType, Integer> resultEntry : result.entrySet()) {
                int couourInAtm = coupursInAtm.get(resultEntry.getKey());
                coupursInAtm.put(resultEntry.getKey(), couourInAtm - resultEntry.getValue());
            }
            return result;
        }

        throw new RuntimeException("We don't have coures");

    }

    public static void main(String[] args) {
        Integer sumToGet = 7000;

        HashMap<CoupurType, Integer> coupusToInitAtm = new HashMap<>();
        coupusToInitAtm.put(CoupurType.c5000, 1);
//        coupusToInitAtm.put(CoupurType.c1000, 10);
//        coupusToInitAtm.put(CoupurType.c500, 10);
//        coupusToInitAtm.put(CoupurType.c100, 10);
//        coupusToInitAtm.put(CoupurType.c50, 10);

        Map<CoupurType, Integer> coupureToGet = new ATM(coupusToInitAtm).getMoney(sumToGet);



        System.out.println(coupureToGet);
    }

    enum CoupurType {

        c5000(5000),

        c1000(1000),
        c500(500),
        c100(100),
        c50(50);
        private int nomial;

        CoupurType(int nominal) {
            this.nomial = nominal;
        }

        public int getNomial() {
            return nomial;
        }
    }
}