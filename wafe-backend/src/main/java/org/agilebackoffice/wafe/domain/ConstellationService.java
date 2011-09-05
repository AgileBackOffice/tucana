/**
 * 
 */
package org.agilebackoffice.wafe.domain;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kamann
 * 
 */
@Service
@Transactional
public class ConstellationService {

	@Inject
	private ConstellationRepository constellationRepository;
	
	@Inject
	private CommentRepository commentRepository;

	public Constellation persistConstellation(
			Constellation constellation2Persist) {
		return constellationRepository.persistConstellation(constellation2Persist);
	}

	public List<Constellation> findAllConstellations() {
		return constellationRepository.findAllConstellations();
	}

	public Constellation findConstellationByCode(String code) {
		return constellationRepository.findConstellationByCode(code);
	}

	public List<Constellation> findAllConstellationByCodeOrName(String code,
			String name) {
		return constellationRepository.findAllConstellationByCodeOrName(code, name);
	}
	
	public List<Comment> findAllCommentsByConstellation(Constellation constellation){
		return commentRepository.findAllCommentsByConstellation(constellation);
	}
	
	public Comment addCommentToConstellation(Constellation constellation, Comment comment){
		comment.setConstellation(constellation);
		return commentRepository.persistComment(comment);
	}
	
	public Comment removeCommentFromConstellation(Comment comment){
		return commentRepository.removeComment(comment);
	}

}
