package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;
@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;
	
	@Autowired // Java dünyasında çok popülerdir. Yeni nesil projelerde %100'e yakın kullanım oranı vardır.
	//Normalde bağımlılık oluştursa da, bu şekilde kullanılmaktadır. Projeyi tarar,
	//projede buna karşılık gelen sınıf varsa onu yerleştirmektedir. Injection'ı bu şekilde yapmaktadır.
	
	public JobTitleManager (JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
		
	}

	
	@Override
	public DataResult<List<JobTitle>> getAll(){
		
	return new SuccessDataResult<List<JobTitle>> 
	(this.jobTitleDao.findAll(),"Data listelendi."); 
		
		
	}


	@Override
	public Result add(JobTitle jobtitle) {
		this.jobTitleDao.save(jobtitle);
		return new SuccessResult("İş eklendi.");
	}



}