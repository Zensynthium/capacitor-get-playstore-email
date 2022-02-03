import { registerPlugin } from '@capacitor/core';

import type { GetPlaystoreEmailPlugin } from './definitions';

// This Plugin only works for android as there is no web equivalent to grabbing an email without user permission and this approach hasn't been adapted for ios yet.
const GetPlaystoreEmail = registerPlugin<GetPlaystoreEmailPlugin>('GetPlaystoreEmail', {
  web: () => import('./web').then(m => new m.GetPlaystoreEmailWeb()),
});

export * from './definitions';
export { GetPlaystoreEmail };
