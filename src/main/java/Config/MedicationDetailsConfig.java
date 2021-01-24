package Config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.group3.backend.ui.model.request.MedicationDetailsModel;
import com.group3.backend.ui.model.response.MedicationDetailsRepository;



@Configuration
public class MedicationDetailsConfig {
	
	@Bean
	CommandLineRunner clr (MedicationDetailsRepository repository) {
		return args -> {
			MedicationDetailsModel med = new MedicationDetailsModel(
					"pain killer",
					2,
					'b',
					"paracetamol",
					"ABC",
					13
					);
			MedicationDetailsModel med1 = new MedicationDetailsModel(
					"pain relive",
					2,
					'b',
					"Noname",
					"ABC",
					1
					);
		
			repository.saveAll(List.of(med,med1));
		};
		
	}
}
