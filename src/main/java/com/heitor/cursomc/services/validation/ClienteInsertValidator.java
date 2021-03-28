package com.heitor.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.heitor.cursomc.domain.DTO.ClienteNewDTO;
import com.heitor.cursomc.domain.enums.TipoCliente;
import com.heitor.cursomc.resources.exception.FieldMessege;
import com.heitor.cursomc.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessege> list = new ArrayList<>();
		
		// inclua os testes aqui, inserindo erros na lista
		if(objDto.getTipoCliente().equals(TipoCliente.PESSOA_FISICA.getCod()) && BR.validaCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessege("cpfOuCnpj", "CPF Invalido"));
			System.out.println(" = = = = =  =====");
		}
		
		if(objDto.getTipoCliente().equals(TipoCliente.PESSOA_JURIDICA.getCod()) && BR.validaCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessege("cpfOuCnpj", "CNPJ Invalido"));
		}
		
		
		for (FieldMessege e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		return list.isEmpty();
	}
}
