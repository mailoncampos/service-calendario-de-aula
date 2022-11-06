package br.com.onlinecarlinda.servicecalendariodeaula.dominio.entidade.vo;

public abstract interface FabricaCPF {

	public default CPF stringToCpfValido(String cpf) {

		CPF cpfValido = new CPF();
		
		if (cpf.length() > 11) {
			cpfValido.setCpf(validarCpfComMascara(cpf)); 
			return cpfValido;			
		}

		if (cpf.length() == 11) {
			cpfValido.setCpf(validarCpf(cpf)); 
			return cpfValido;			
		}
		throw new IllegalArgumentException("CPF não contém o mínimo de onze digitos");

	}

	private String validarCpfComMascara(String cpf) {

		if (!cpf.matches("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")) {
			throw new IllegalArgumentException("Formato do CPF incorreto. Ex: 999.999.999-99");
		}
		try {
			cpf = cpf.replaceAll("\\.", "");
		} catch (RuntimeException e) {
			throw new RuntimeException("Erro ao realizar a conversão do CPF");
		}


		return validarCpf(cpf);
	}

	private String validarCpf(String cpf) {

		
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("CPF não contém 11 digitos");
		}
		
		calculoDigitosVerificadores(cpf);

		return cpf;
	}

	private void calculoDigitosVerificadores(String cpf) {
		
		int posicaoZeroASCII = 48; //(48 corresponde a posicao do '0' na tabela ASCII)

		char dig10, dig11;
		int sm, i, r, num, peso;

		// Calculo do 1º. Digito Verificador
		sm = 0;
		peso = 10;
		for (i = 0; i < 9; i++) {
			
			num = (int) (cpf.charAt(i) - posicaoZeroASCII);
			sm = sm + (num * peso);
			peso = peso - 1;
		}
		
		r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig10 = '0';
        else dig10 = (char)(r + posicaoZeroASCII);
		
		// Calculo do 2º. Digito Verificador
        sm = 0;
        peso = 11;
        for(i=0; i<10; i++) {
        num = (int)(cpf.charAt(i) - posicaoZeroASCII);
        sm = sm + (num * peso);
        peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
             dig11 = '0';
        else dig11 = (char)(r + posicaoZeroASCII);
        
        if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
             return;
        
        throw new IllegalArgumentException("O CPF informado é inválido");

	}

}
