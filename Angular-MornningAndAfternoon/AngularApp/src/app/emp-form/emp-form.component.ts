import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
@Component({
  selector: 'emp-form',
  templateUrl: './emp-form.component.html',
  styleUrls: ['./emp-form.component.css']
})
export class EmpFormComponent  {
  list :any =[]

  form = new FormGroup({
    firstname: new FormControl('',Validators.required),
    lastname: new FormControl('',Validators.required),
    contact: new FormControl('',Validators.required),
    dob : new FormControl(),
    city: new FormControl('',Validators.required),
    pin :new FormControl('',Validators.required)
  });

  details(){
    this.list.push(this.form.value);
    console.log(this.list);


  }

  form2 = new FormGroup({
    delname : new FormControl()
  });

  delete(){
    let name = this.form2.value.delname;

    console.log(name);

    var nl=this.list.filter((item:any)=>item.firstname!=name)
    console.log(nl)
    this.list=nl

  }

  sort(param:any){
    this.list.sort((a:any,b:any) => a.param > b.param ? 1 :-1 )
  }


}
