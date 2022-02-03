import { WebPlugin } from '@capacitor/core';

import type { GetPlaystoreEmailPlugin } from './definitions';

export class GetPlaystoreEmailWeb extends WebPlugin implements GetPlaystoreEmailPlugin {
  async getAccount(): Promise<{ email: string }> {
    console.log('GetPlaystoreEmail/GetPlaystoreEmailWeb doesn\'t work on web.');
    return { email: ''}
  }
}
