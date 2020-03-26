package com.mm.languages;

public class ES_ES implements Language{
    
    public String morning() { return general(); }
    public String afternoon() { return "Buenas Tardes"; }
    public String evening() { return "Buena Noches"; }
    public String general() { return "Buenos Dias"; }
  

}
