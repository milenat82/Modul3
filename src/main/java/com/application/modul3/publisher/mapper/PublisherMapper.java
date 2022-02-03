package com.application.modul3.publisher.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.modul3.publisher.Publisher;
import com.application.modul3.publisher.dto.PublisherDTO;

@Service
public class PublisherMapper {

	public PublisherDTO publisherToPublisherDTO(Publisher publisher) {
		PublisherDTO publisherDTO = new PublisherDTO();
		publisherDTO.setId(publisher.getId());
		publisherDTO.setName(publisher.getName());
		publisherDTO.setAddress(publisher.getAddress());
		return publisherDTO;
	}

	public Publisher publisherDTOToPublisher(PublisherDTO publisherDTO) {
		Publisher publisher = new Publisher();
		publisher.setId(publisherDTO.getId());
		publisher.setName(publisherDTO.getName());
		publisher.setAddress(publisherDTO.getAddress());
		return publisher;
	}

	public List<PublisherDTO> publisherListToPublisherListDTO(List<Publisher> publishers) {
		return publishers.stream().map(publisher -> publisherToPublisherDTO(publisher)).collect(Collectors.toList());
	}
}
