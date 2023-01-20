public class PhoneBook {

    public boolean solution(String[] phone_book) {
        for(int i=0;i<phone_book.length;i++){
            phone_book[i]=phone_book[i].replaceAll(" ","");
        }
        for(int i=0;i<phone_book.length;i++){
            for(int j=0;j<phone_book.length;j++){
                if(phone_book[i].length()<phone_book[j].length()){
                    if(phone_book[j].substring(0,phone_book[i].length()).equals(phone_book[i])){
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
