package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import com.example.demo.util.FileUtil;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository repository;
	
	@Autowired
	private FileUtil fileUtil;

	@Override
	public int register(BoardDTO dto) {
		Board entity = dtoToEntity(dto);
		
		//유틸클래스를 이용해서 파일을 폴더에 저장하고 파일이름을 반환받는다
		String imgPath = fileUtil.fileUpload(dto.getUploadFile());
		//그리고 엔티티에 파일이름을 저장한다
		entity.setImgPath(imgPath);
		
		repository.save(entity);

		return entity.getNo();
	}

	@Override
	public Page<BoardDTO> getList(int page, String search) {
		int pageNum = (page == 0) ? 0 : page - 1;
		Pageable pageable = PageRequest.of(pageNum, 10, Sort.by("no").descending());
		Page<Board> entityPage = null;
		if(search.equals("")) {
			entityPage = repository.findAll(pageable);
		} else {
			entityPage = repository.findByTitleContaining(search,pageable);
		}
		
		Page<BoardDTO> dtoPage = entityPage.map( entity -> entityToDto(entity) );

		return dtoPage;
	}

	@Override
	public BoardDTO read(int no) {
        Optional<Board> result = repository.findById(no);
        if(result.isPresent()) {
        	Board board =  result.get();
        	return entityToDto(board);
        } else {
        	return null;
        }
	}

	@Override
	public void modify(BoardDTO dto) {
        Optional<Board> result = repository.findById(dto.getNo());
        if(result.isPresent()){
            Board entity = result.get();
            entity.setTitle(dto.getTitle());
            entity.setContent(dto.getContent());
            
    		//유틸클래스를 이용해서 파일을 폴더에 저장하고 파일이름을 반환받는다
    		String imgPath = fileUtil.fileUpload(dto.getUploadFile());
    		//엔티티에 파일이름을 저장한다
    		if(imgPath != null) {
    			entity.setImgPath(imgPath);
    		}
    		
            repository.save(entity);
        }
	}

	@Override
	public void remove(int no) {
		repository.deleteById(no);
	}

}
