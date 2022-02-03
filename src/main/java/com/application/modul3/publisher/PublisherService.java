package com.application.modul3.publisher;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
	@Autowired
	private PublisherRepository publisherRepository;

	public Publisher createPublisher(Publisher publisher) {
		return publisherRepository.saveAndFlush(publisher);
	}

	public List<Publisher> getAllPublishers() {
		return publisherRepository.findAll();
	}

	public Publisher updatePublisher(Publisher publisher, Integer id) {
		Publisher publisherUpdate = getPublisherById(id);
		publisherUpdate.setAddress(publisher.getAddress());
		publisherUpdate.setName(publisher.getName());
		publisherRepository.flush();
		return publisherUpdate;
	}

	public void detelePublisherById(Integer id) {
		publisherRepository.deleteById(id);
	}

	public Publisher getPublisherById(Integer id) {
		Optional<Publisher> publisherOpt = publisherRepository.findById(id);
		if (publisherOpt.isPresent()) {
			return publisherOpt.get();
		}
		return null;
	}

}
