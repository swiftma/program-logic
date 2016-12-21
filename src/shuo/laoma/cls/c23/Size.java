package shuo.laoma.cls.c23;

public enum Size {
    SMALL("S","小号"), 
    MEDIUM("M","中号"), 
    LARGE("L","大号");
    
    private String abbr;
    private String title;
    
    private Size(String abbr, String title){
        this.abbr = abbr;
        this.title = title;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getTitle() {
        return title;
    }
    
    public static Size fromAbbr(String abbr){
        for(Size size : Size.values()){
            if(size.getAbbr().equals(abbr)){
                return size;
            }
        }
        return null;
    }
}