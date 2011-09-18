/**
 * 
 */
package org.agilebackoffice.wafe.web;

import java.util.List;

import javax.inject.Inject;

import org.agilebackoffice.wafe.domain.Constellation;
import org.agilebackoffice.wafe.domain.ConstellationService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		return new ModelAndView("xmlView", BindingResult.MODEL_KEY_PREFIX
				+ "constellations", service.findConstellationByCode(code));
	}

	@RequestMapping("/constellations_by_search/{search}")
	public ModelAndView findConstellationByCodeOrName(
			@PathVariable String search) {
		return new ModelAndView("xmlView", BindingResult.MODEL_KEY_PREFIX
				+ "constellations",
				service.findAllConstellationByCodeOrName(search));
	}

	@RequestMapping("/comments_by_constellation/{code}")
	public ModelAndView findAllCommentsByConstellation(@PathVariable String code) {
		Constellation constellation = service.findConstellationByCode(code);
		if (constellation == null) {
			return null;
		}

		return new ModelAndView("xmlView", BindingResult.MODEL_KEY_PREFIX
				+ "constellations",
				service.findAllCommentsByConstellation(constellation));
	}

}
