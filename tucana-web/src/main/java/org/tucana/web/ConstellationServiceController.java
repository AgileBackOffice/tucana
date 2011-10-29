/**
 * 
 */
package org.tucana.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.tucana.domain.Constellation;
import org.tucana.domain.ConstellationName;
import org.tucana.service.ConstellationService;

/**
 * @author kamann
 * 
 */
@Controller
public class ConstellationServiceController {

	@Inject
	private ConstellationService service;

	@RequestMapping(value = "/constellations")
	public ModelAndView getAllConstellations() {
		List<Constellation> constellations = service.findAllConstellations();
		ModelAndView mav = new ModelAndView("xmlView",
				BindingResult.MODEL_KEY_PREFIX + "constellations",
				constellations);
		return mav;
	}

	@RequestMapping("/constellation_by_code/{code}")
	public ModelAndView findConstellationByCode(@PathVariable String code) {
		Constellation constellation = service.findConstellationByCode(code);
		for (ConstellationName name : constellation.getNames()) {
			name.toString();
		}
		return new ModelAndView("xmlView", BindingResult.MODEL_KEY_PREFIX
				+ "constellations", constellation);
	}

	@RequestMapping("/constellations_by_search/{search}")
	public ModelAndView findConstellationByCodeOrName(
			@PathVariable String search) {
		return new ModelAndView("xmlView", BindingResult.MODEL_KEY_PREFIX
				+ "constellations",
				service.findAllConstellationByCodeOrName(search));
	}
}
