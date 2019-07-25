import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'bold'
})
export class TextBoldPipe implements PipeTransform {

  transform(value: string): any {
    return '<b>' + value + '</b>';
 }
}
