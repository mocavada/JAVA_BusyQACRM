import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchItem'
})
export class SearchItemPipe implements PipeTransform {

  transform(pipeData: any[], pipeModifier: string): any {
    return pipeData.filter(eachItem => {
      return (
        eachItem.firstName.toLowerCase().includes(pipeModifier.toLowerCase()) ||
        eachItem.email.toLowerCase().includes(pipeModifier.toLowerCase())
        );
    });
  }

}
