package quinemcclusky;

public class QuineMcClusky {
    private String minTerms = "";
    private int virgulSayisi = 0;
    private int bitSayisi = 0;
    private String minTerm[][];
    private String minTerm2[];
    private String fromDecToBi(String sayi){
        int decSayi = Integer.parseInt(sayi);
        String sonuc = "";
        String temp;
        while(decSayi > 1){
            temp = sonuc;
            sonuc = String.valueOf(decSayi%2);
            sonuc += temp;
            decSayi /= 2;
        }
        if(decSayi != 0){
            temp = sonuc;
            sonuc = "1";
            sonuc += temp;
        }
        if(sonuc == "" && decSayi == 0){
            return 0+"";
        }
        return sonuc;
    }
      
    private boolean hata(String minTerms){
        
        for (int i = 0; i < minTerms.length(); i++) {
            if(minTerms.charAt(i) == ','){
                virgulSayisi++;
            }
            else if( minTerms.charAt(i) == ' '){
                
            }
            else if((int) (minTerms.charAt(i)) >= 48 && (int) (minTerms.charAt(i)) <= 57){
                
            }
            else{
                virgulSayisi = 0;
                return true;
            }
        }
        if(minTerms.length()<1)
            return true;
        else 
            return false;
    }
    public QuineMcClusky(String minTerms){
        this.minTerms = minTerms;
    }
    public QuineMcClusky(String minTerms, int bitSayisi){
        this.minTerms = minTerms;
        this.bitSayisi = bitSayisi;
    }
    private String createEquation(String dizi[]){//denklem oluştur.
        dizi = benzelikleriIsle(dizi);
        //Dizideki null ları ortadan kaldırıyorum
        int diziUzunluk = dizi.length;
        for (int i = 0; i < dizi.length; i++) {
            if(dizi[i] == null)
                diziUzunluk--;
        }
        String[] asallarDizi =new String[diziUzunluk];
        int sayac = 0;
        for (int i = 0; i < dizi.length; i++) {
            if(dizi[i] != null){
                asallarDizi[sayac] = dizi[i];
                sayac++;
            }
        }
        System.out.println("dizinin elemanları..................");
        for (int i = 0; i < asallarDizi.length; i++) {
            System.out.println(i+". eleman :"+asallarDizi[i]);
        }
        String asilAsallar = asilAsallar(asallarDizi);
        return asilAsallar;
    }
    private String asilAsallar(String asallar[]){
        int degerTablosu [][] = new int [asallar.length][minTerm2.length] ;
        boolean ayni = false;
        for (int i = 0; i < asallar.length; i++) {
            for (int j = 0; j < minTerm2.length; j++) {
                for (int k = 0; k < bitSayisi; k++) {
                    if(asallar[i].charAt(k) == '-'){
                        ayni = true;
                    }
                    else if(asallar[i].charAt(k) == minTerm2[j].charAt(k)){
                        ayni = true;
                    }
                    else{
                        ayni = false;
                        break;
                    }
                }
                if(ayni)
                    degerTablosu[i][j] = 1;
                ayni = false;
            }
        }
          //Matris halinde tablo oluşumu
            System.out.println("Tablo oluşumu");
            for (int i = 0; i < degerTablosu.length; i++) {
            System.out.print(i+" :");
            for (int j = 0; j < degerTablosu[i].length; j++) {
                System.out.print(degerTablosu[i][j]+" ");
            }
            System.out.println("");
        }/**/
        int asilAsallar[] = new int [degerTablosu.length];
        boolean farkli = true;
        for (int i = 0; i < degerTablosu.length; i++) {
            for (int j = 0; j < degerTablosu[i].length; j++) {
                for (int k = 0; k < degerTablosu.length; k++) {       
                    if(k != i && degerTablosu[i][j] == 1){
                        if( degerTablosu[k][j] == 1)
                            break;
                    }
                    else if(degerTablosu[i][j] == 0)
                        break;
                    if(k == degerTablosu.length-1){
                        asilAsallar[i] = 1;
                    }           
                }
                if(asilAsallar[i] == 1)
                    break;
            }
        }
        System.out.println("Asıl asallar:");
        for (int i = 0; i < asilAsallar.length; i++) {
            System.out.println(" "+ asilAsallar[i]);
        }
        String sonuc = harflereDonustur(asilAsallar,asallar);
        return sonuc;
    }
    private String harflereDonustur(int asilAsallar[],String asallar[]){
        String sonuc = "";
        for (int i = 0; i < asilAsallar.length; i++) {
            if(asilAsallar[i] == 1){
                for (int j = 0; j < asallar[i].length(); j++) {
                    if(asallar[i].charAt(j) == '0'){
                        sonuc += (char)(97 + j)+"'";
                    }
                    else if(asallar[i].charAt(j) == '1'){
                        sonuc += (char)(97 + j);
                    }
                }
                if(asilAsallar.length -1 != i)
                sonuc += "+";
            }
        }
        return sonuc;
    }
    private String [] benzelikleriIsle(String dizi[]){
        int n = virgulSayisi+1;
        String[] yeniDizi = new String [n*(n+1)];
        int benzemeTablosu [] = new int [dizi.length];
        int sayac = 0;
        boolean benzermi = false;
        int degisim = 0;
        for (int i = 0; i < dizi.length-1; i++) {
            for (int j = i + 1; j < dizi.length; j++) {
                benzermi = false;
                if( dizi[i] == null || dizi[j] == null || dizi[i] == dizi[j] ){
                    
                }
                else{
                    
                    int eleman = -1;
                    for (int k = 0; k < bitSayisi; k++) {
                        if((dizi[i].charAt(k)) == (dizi[j].charAt(k))){
                            
                        }
                        else{
                            if(benzermi){
                                benzermi = false;
                                eleman = -1;
                                break;
                            }
                            else{
                                benzermi = true;
                                eleman = k;
                            }
                        }
                    }
                    if(eleman != -1){
                        
                        String temp = "";
                        for (int k = 0; k < bitSayisi; k++) {
                            if(k == eleman)
                                temp += '-';
                            else
                                temp += dizi[i].charAt(k);
                        }
                        boolean esitmi = false;
                        for (int k = 0; k < sayac; k++) {
                            if(yeniDizi[k] == null ? temp == null : yeniDizi[k].equals(temp)){
                               
                                esitmi = true;
                            }
                        }
                        if(!esitmi){
                            yeniDizi[sayac] = temp;
                        }else
                            sayac--;
                        
                        benzemeTablosu[i] = 1;
                        benzemeTablosu[j] = 1;
                        degisim = 1;
                        sayac++;
                    }
                }
            }
        }
        for (int i = 0; i < dizi.length; i++) {//Hiçbir şeyle benzer olmayanlar ekleniyor.
            if(benzemeTablosu[i] != 1){
                yeniDizi[sayac] = dizi[i];
                sayac++;
            }   
        }
        if(degisim == 0 )
            return yeniDizi;
        else
            return benzelikleriIsle(yeniDizi);
    }
    private String [] sirala(String dizi[][]){//0 sayısı çok olandan az olana siralama
        int sayi1,sayi2;
        String sonuc []= new String [dizi.length];
        int sifirSa;
        int diziUzu;
        for (int i = 0; i < dizi.length; i++) {
            sifirSa =  Integer.parseInt(dizi[i][1]);
            diziUzu = dizi[i][0].length();
            if(diziUzu < bitSayisi){
                for (int j = 0; j < bitSayisi - diziUzu; j++) {
                    dizi[i][0] = "0" + dizi[i][0];
                }
                dizi[i][1] = sifirSa + bitSayisi - diziUzu +"";
            }
        }
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi.length-1; j++) {
                
                sayi1 = Integer.parseInt(dizi[i][1]);
                sayi2 = Integer.parseInt(dizi[j][1]);
                if(sayi1 > sayi2){
                    dizi[i][1] = sayi2 + "";
                    dizi[j][1] = sayi1 + "";
                    String temp = dizi[i][0];
                    dizi[i][0] = dizi[j][0];
                    dizi[j][0] = temp;
                }
            }
        }
        for (int i = 0; i < dizi.length; i++) {
            sonuc[i] = dizi[i][0];
        }
        return sonuc;
    }
    protected String denklem(){
        String denklemSonuc;
        if(!hata(minTerms)){
            minTerms += ',';//aşağıdaki ',' kontrolünde hata vermemesi için
            minTerm = new String[virgulSayisi+1][2];//Terim sayısı ve 0 sayısının kaç adet oluğu gelecek.
            String sayi = "";
            int sayac = 0;
            int eb = 0;
            
            for (int i = 0; i < minTerms.length(); i++) {
                
                if(minTerms.charAt(i) == ',' ){
                    eb = Integer.parseInt(sayi);
                    if(eb < Integer.parseInt(sayi))
                        eb = Integer.parseInt(sayi);
                    String ara = fromDecToBi(sayi);
                    int sifirSayisi = 0;
                    for (int j = 0; j < ara.length(); j++) {//kaç adet 0 var?
                        if(ara.charAt(j) == '0')
                            sifirSayisi++;
                    }
                    minTerm[sayac][0] = ara;
                    minTerm[sayac][1] = sifirSayisi+"";
                    sayac++;
                    sayi = "";
                }
                else if((int) (minTerms.charAt(i)) >= 48 && (int) (minTerms.charAt(i)) <= 57){
                    sayi += minTerms.charAt(i);
                }
                
            }
            if(bitSayisi == 0)
                bitSayisi = (int) (Math.log(eb)/Math.log(2))+1;
            minTerm2 = sirala(minTerm);
            System.out.println("İlk terimlerin sıralanmış hali:");
            for (int i = 0; i < minTerm2.length; i++) {
                System.out.println(minTerm2[i]);
            }
            
            denklemSonuc = createEquation(minTerm2);
            
        }
        else{
            System.out.println("Lütfen minimum terimleri giriniz. Bir hata oluştu.");
            return null;
        }
        return denklemSonuc;
    }
    public static void main(String[] args) {
        //QuineMcClusky qmc = new QuineMcClusky("1,2,3,5,8,9,10,11,13,14,15");
        //QuineMcClusky qmc = new QuineMcClusky("0,4,5,7,8,11,12,15,397,921,1978,56,878,2,222,10326");
        QuineMcClusky qmc = new QuineMcClusky("0,1,2");
        //QuineMcClusky qmc = new QuineMcClusky("3,5,6,7");
        System.out.println("Denklem: "+qmc.denklem());
        
    }
}
//b'c+c'd+ab'+ac
