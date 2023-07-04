package br.edu.univas.process.processDto;

import br.edu.univas.process.entities.ProcessEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProcessDTO {
	
	private Long code;
	private String responsible;
	private String lastReview;
	private Integer qualityRate;
	private String probabilityNewDeals;
	private boolean active;


	public ProcessDTO(ProcessEntity product) {
		this.code = product.getCode();
		this.responsible = product.getResponsible();
		this.lastReview = product.getLastReview();
		this.qualityRate = product.getQualityRate();
		this.probabilityNewDeals = product.getProbabilityNewDeals();
		this.active = product.isActive();
	}

}
