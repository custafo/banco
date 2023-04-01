    public enum Week{
		DOMINGO(1.2f),
		SEGUNDA(1.8f),
		TERÇA(1.5f),
		QUARTA(1.5f),
		QUINTA(1.5f),
		SEXTA(1.5f),
		SABADO(1.2f),;
    
    private float multiplier;

    public float getMultiplier(){
        return multiplier;
    }

    Week(float multiplier){
        this.multiplier = multiplier;
    }
}
