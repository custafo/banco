    public enum Week{
		DOMINGO(0.6f),
		SEGUNDA(1f),
		TERÇA(1f),
		QUARTA(1f),
		QUINTA(1f),
		SEXTA(1f),
		SABADO(0.8f),;
    
    private float multiplier;

    public float getMultiplier(){
        return multiplier;
    }

    Week(float multiplier){
        this.multiplier = multiplier;
    }
}
