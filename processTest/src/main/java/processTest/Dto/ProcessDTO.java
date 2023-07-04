package processTest.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessDTO {
	
	private String code;
	private String responsible;
	private String lastReview;
	private Integer qualityRate;
	private String probabilityNewDeals;

}
