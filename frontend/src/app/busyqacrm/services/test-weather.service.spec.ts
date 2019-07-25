/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { TestWeatherService } from './test-weather.service';

describe('Service: TestWeather', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TestWeatherService]
    });
  });

  it('should ...', inject([TestWeatherService], (service: TestWeatherService) => {
    expect(service).toBeTruthy();
  }));
});
